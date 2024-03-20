package com.sqg.flow.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlowHolder {

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
        System.out.println("add flow : " + flowInstance.getFlowName());
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
}
