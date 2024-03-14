package com.sqg.flow;

import java.util.LinkedList;
import java.util.List;

public class FlowHolder {

    private List<FlowInstance> flowInstances;

    public FlowHolder() {

    }

    public FlowHolder(List<FlowInstance> flowInstances) {
        this.flowInstances = flowInstances;
    }

    public List<FlowInstance> getFlows() {
        return flowInstances;
    }
    public void setFlows(List<FlowInstance> flowInstances) {
        this.flowInstances = flowInstances;
    }

    public void addFlow(FlowInstance flowInstance) {
        if (this.flowInstances == null){
            this.flowInstances = new LinkedList<>();
        }
        this.flowInstances.add(flowInstance);
    }
}
