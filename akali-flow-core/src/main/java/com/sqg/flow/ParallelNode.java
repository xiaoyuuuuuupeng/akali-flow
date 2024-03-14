package com.sqg.flow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ParallelNode extends Node{

    private List<Node> nodes;

    ThreadPoolExecutor pool;
    public ParallelNode(String name) {
        super(name);
    }
    public ParallelNode(String name, ThreadPoolExecutor pool) {
        super(name);
        this.pool = pool;
    }

    public void setNodes(List<Node> nodes){
        this.nodes = nodes;
    }
    public List<Node> getNodes(){
        return this.nodes;
    }
    public void addNode(Node node){
        this.nodes.add(node);
    }

    @Override
    public void execute(Map<String, Object> context) {
        CompletableFuture<?>[] futureList = new CompletableFuture[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                node.execute(context);
            }, pool);
            futureList[i] = completableFuture;
        }
        try {
            CompletableFuture<Void> completableFuture = CompletableFuture.allOf(futureList);
            completableFuture.get();
        }catch (Exception e){
            System.out.println("ParallelNode execute error");
        }
    }
}
