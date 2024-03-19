package com.sqg.flow.core;

import com.sqg.flow.core.model.FlowMap;
import com.sqg.flow.core.model.FlowReq;
import com.sqg.flow.core.model.FlowRes;

public abstract class BaseNode {

    private String name;
    private FlowMap props;
    private FlowMap flowContext;

    public BaseNode() {
    }

    public BaseNode(String name) {
        this.name = name;
    }

    public BaseNode(String name, FlowMap props) {
        this.name = name;
        this.props = props;
    }

    public BaseNode(String name, FlowMap props, FlowMap flowContext) {
        this.name = name;
        this.props = props;
        this.flowContext = flowContext;
    }

    public abstract void execute() throws Exception;

    public FlowMap getProps() {
        return props;
    }

    public void setProps(FlowMap props) {
        this.props = props;
    }

    public FlowMap getFlowContext() {
        return flowContext;
    }

    public void setFlowContext(FlowMap flowContext) {
        this.flowContext = flowContext;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void entry(){
    }
    public void exit(){
    }
}
