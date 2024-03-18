package com.sqg.flow.core.config;

import java.util.List;
import java.util.Map;

public class FlowConfig {

    private String flowName;
    private String startTime;
    private List<NodeConfig> nodes;
    private Map<String, Object> props;

    private String el;
    public FlowConfig() {
    }

    public List<NodeConfig> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeConfig> nodes) {
        this.nodes = nodes;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }

    public String getEl() {
        return el;
    }

    public void setEl(String el) {
        this.el = el;
    }
}
