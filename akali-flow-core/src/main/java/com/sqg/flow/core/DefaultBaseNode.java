package com.sqg.flow.core;



public class DefaultBaseNode extends BaseNode {

    public DefaultBaseNode() {
    }

    public DefaultBaseNode(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("DefaultNode execute,i am " + this.getName() + " ----- threadName:" + Thread.currentThread().getName());
    }
}
