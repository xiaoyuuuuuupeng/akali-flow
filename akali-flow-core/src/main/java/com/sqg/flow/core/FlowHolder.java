package com.sqg.flow.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            this.flowInstances = new HashMap<>();
        }
        this.flowInstances.put(flowInstance.getFlowName(),flowInstance);
    }

    public void addFlow(String name,FlowInstance flowInstance) {
        if (this.flowInstances == null){
            this.flowInstances = new HashMap<String,FlowInstance>();
        }
        this.flowInstances.put(name,flowInstance);
    }

    public void putAll(Map<String,FlowInstance> flowInstance) {
        if (this.flowInstances == null){
            this.flowInstances = new HashMap<String,FlowInstance>();
        }
        this.flowInstances.putAll(flowInstance);
    }

    public void putAll(List<FlowInstance> flowInstances) {
        if (this.flowInstances == null){
            this.flowInstances = new HashMap<String,FlowInstance>();
        }
        flowInstances.forEach(flowInstance -> this.flowInstances.put(flowInstance.getFlowName(),flowInstance));
    }
}
