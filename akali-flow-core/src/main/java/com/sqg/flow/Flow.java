package com.sqg.flow;


import cn.hutool.core.thread.NamedThreadFactory;
import com.sqg.flow.config.FlowConfig;
import com.sqg.flow.config.NodeConfig;
import com.sqg.flow.enums.FlowStatusEnum;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Flow {
    List<Node> nodes;
    int status;
    private final int queueSize = 1000;
    private int threads;
    NamedThreadFactory threadFactory;
    ThreadPoolExecutor pool ;

    public Flow() {
        status = FlowStatusEnum.INIT.getStatus();
        threads = Runtime.getRuntime().availableProcessors();
        threadFactory = new NamedThreadFactory("parallel_node_pool_",false);
        pool = new ThreadPoolExecutor(this.threads, this.threads, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(this.queueSize), this.threadFactory);
        pool.prestartAllCoreThreads();
    }

    public Flow createFlow(FlowConfig flowConfig){
        nodes = loadNodes(flowConfig.getNodes());
        return this;
    }

    private List<Node> loadNodes(List<NodeConfig> nodeConfigs) {
        LinkedList<Node> nodeLinkedList = new LinkedList<>();
        for (NodeConfig nodeConfig : nodeConfigs) {
            Node node = createNode(nodeConfig);
            nodeLinkedList.add(node);
        }
        return nodeLinkedList;
    }

    public Node createNode(NodeConfig nodeConfig) {
        String className = nodeConfig.getClassName();
        if (className != null && !"".equals(className)){
           return (Node)instanceClass(className);
        }
        String factoryClass = nodeConfig.getFactoryClass();
        if (factoryClass != null && !"".equals(factoryClass)){
            Object o = instanceClass(factoryClass);
            NodeFactory nodeFactory = (NodeFactory) o;
            return nodeFactory.createNode(nodeConfig);
        }

        if (nodeConfig.getIsParallel() == 1){
            ParallelNode parallelNode = new ParallelNode(nodeConfig.getName(),pool);
            parallelNode.setNodes(loadNodes(nodeConfig.getParallelNodes()));
            return parallelNode;
        }
        return new DefaultNode(nodeConfig.getName());
    }

    public Object instanceClass(String className){
        try {
            Class<?> ClassTemplate = Class.forName(className);
            return ClassTemplate.newInstance();
        }catch (ClassNotFoundException e){
            throw new RuntimeException("找不到类：" + className);
        }catch (InstantiationException | IllegalAccessException  e){
            throw new RuntimeException("实例化类失败：" + className);
        }
    }

    public synchronized void start() {
        assert nodes.size() > 0 : "节点为空";
        status = FlowStatusEnum.START.getStatus();
        for (Node node : nodes) {
            node.execute(null);
        }
    }

    public synchronized void end() {
        status = FlowStatusEnum.END.getStatus();
        pool.shutdown();
    }
}
