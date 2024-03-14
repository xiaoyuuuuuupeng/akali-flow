package com.sqg.flow;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ParallelBaseNode extends BaseNode {

    private List<BaseNode> baseNodes;
    private ThreadPoolExecutor pool;
    private final int queueSize = 1000;
    private int threads;
    private NamedThreadFactory threadFactory;

    public ParallelBaseNode() {
        initPool();
    }
    public ParallelBaseNode(String name) {
        super(name);
        initPool();
    }
    public void initPool(){
        threads = Runtime.getRuntime().availableProcessors();
        threadFactory = new NamedThreadFactory("parallel_node_pool_",false);
        pool = new ThreadPoolExecutor(this.threads, this.threads, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(this.queueSize), this.threadFactory);
        pool.prestartAllCoreThreads();
    }
    public void setNodes(List<BaseNode> baseNodes){
        this.baseNodes = baseNodes;
    }
    public List<BaseNode> getNodes(){
        return this.baseNodes;
    }
    public void addNode(BaseNode baseNode){
        this.baseNodes.add(baseNode);
    }

    @Override
    public Map<String, Object> execute(Map<String, Object> context) {
        if (context == null){
            context = new HashMap<>();
        }
        CompletableFuture<Map<String, Object>>[] futureList = new CompletableFuture[baseNodes.size()];
        for (int i = 0; i < baseNodes.size(); i++) {
            BaseNode baseNode = baseNodes.get(i);
            Map<String, Object> finalContext = context;
            CompletableFuture<Map<String, Object>> future = CompletableFuture.supplyAsync(() -> {
                return baseNode.execute(finalContext);
            }, pool).whenComplete((ignored, throwable) -> {
                if (throwable != null){
                    System.out.println("execute error");
                    exit();
                    throw new RuntimeException(throwable);
                }
            });
            futureList[i] = future;
        }
        try {
            CompletableFuture.allOf(futureList).join();
            return context;
        }catch (Exception e){
            System.out.println("ParallelNode execute error");
            exit();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void exit(){
        pool.shutdown();
    }
}
