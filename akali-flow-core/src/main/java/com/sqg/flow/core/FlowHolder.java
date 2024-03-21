package com.sqg.flow.core;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FlowHolder {

    private Map<String,BaseNode> nodeMap;
    private Map<String,FlowInstance> flowInstances;

    public FlowHolder() {

    }

    public Map<String, FlowInstance> getFlowInstances() {
        return flowInstances;
    }

    public void setFlowInstances(Map<String, FlowInstance> flowInstances) {
        this.flowInstances = flowInstances;
    }

    public void setFlows(Map<String,FlowInstance> flowInstances) {
        this.flowInstances = flowInstances;
    }

    public void addFlow(FlowInstance flowInstance) {
        if (this.flowInstances == null){
            this.flowInstances = new ConcurrentHashMap<>();
        }
        this.flowInstances.put(flowInstance.getFlowName(),flowInstance);
    }

    public void addFlow(String name,FlowInstance flowInstance) {
        if (this.flowInstances == null){
            this.flowInstances = new ConcurrentHashMap<String,FlowInstance>();
        }
        this.flowInstances.put(name,flowInstance);
    }

    public void putAll(Map<String,FlowInstance> flowInstance) {
        if (this.flowInstances == null){
            this.flowInstances = new ConcurrentHashMap<>();
        }
        this.flowInstances.putAll(flowInstance);
    }

    public void putAll(List<FlowInstance> flowInstances) {
        if (this.flowInstances == null){
            this.flowInstances = new ConcurrentHashMap<String,FlowInstance>();
        }
        flowInstances.forEach(flowInstance -> this.flowInstances.put(flowInstance.getFlowName(),flowInstance));
    }

    public Map<String, BaseNode> getNodeMap() {
        return nodeMap;
    }

    public List<BaseNode> getNodes() {
        if (nodeMap == null || nodeMap.isEmpty()){
            return new LinkedList<>();
        }
        Collection<BaseNode> values = nodeMap.values();
        return new LinkedList<>(values);
    }

    public void setNodeMap(Map<String, BaseNode> nodeMap) {
        this.nodeMap = nodeMap;
    }

    public void addNode(BaseNode node) {
        if (this.nodeMap == null){
            this.nodeMap = new ConcurrentHashMap<>();
        }
        this.nodeMap.put(node.getName(),node);
    }
    public void addNode(String name,BaseNode node) {
        if (this.nodeMap == null){
            this.nodeMap = new ConcurrentHashMap<>();
        }
        this.nodeMap.put(name,node);
    }
}
