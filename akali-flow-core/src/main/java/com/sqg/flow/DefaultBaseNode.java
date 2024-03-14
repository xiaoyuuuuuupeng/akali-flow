package com.sqg.flow;

import java.util.Map;

public class DefaultBaseNode extends BaseNode {

    public DefaultBaseNode() {
    }

    public DefaultBaseNode(String name) {
        super(name);
    }

    @Override
    public Map<String, Object> execute(Map<String, Object> context) {
        System.out.println("DefaultNode execute,i am " + this.getName() + " ----- threadName:" + Thread.currentThread().getName());
        return context;
    }
}
