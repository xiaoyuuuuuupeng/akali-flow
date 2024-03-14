package com.sqg.flow.config;

import java.util.List;
import java.util.Map;

public class NodeConfig {
    private String name;
    private String className;
    private String factoryClass;
    private int isParallel;
    private Map<String,Object> props;
    private List<NodeConfig> parallelNodes;
    private String type;
    public NodeConfig() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }

    public List<NodeConfig> getParallelNodes() {
        return parallelNodes;
    }

    public void setParallelNodes(List<NodeConfig> parallelNodes) {
        this.parallelNodes = parallelNodes;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFactoryClass() {
        return factoryClass;
    }

    public void setFactoryClass(String factoryClass) {
        this.factoryClass = factoryClass;
    }

    public int getIsParallel() {
        return isParallel;
    }

    public void setIsParallel(int isParallel) {
        this.isParallel = isParallel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
