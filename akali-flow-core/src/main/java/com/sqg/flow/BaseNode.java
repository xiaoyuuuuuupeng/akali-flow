package com.sqg.flow;

import java.util.Map;

public abstract class BaseNode {

    private String name;
    private Map<String,Object> props;

    public BaseNode() {
    }

    public BaseNode(String name) {
        this.name = name;
    }

    public BaseNode(String name, Map<String, Object> props) {
        this.name = name;
        this.props = props;
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

    public abstract Map<String,Object> execute(Map<String,Object> context);


    public void entry(){

    }

    public void exit(){

    }
}
