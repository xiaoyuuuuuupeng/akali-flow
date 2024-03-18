package com.sqg.flow.core;

import com.sqg.flow.core.model.FlowReq;
import com.sqg.flow.core.model.FlowRes;


public class DefaultBaseNode extends BaseNode {

    public DefaultBaseNode() {
    }

    public DefaultBaseNode(String name) {
        super(name);
    }

    @Override
    public FlowRes execute(FlowReq flowReq) {
        System.out.println("DefaultNode execute,i am " + this.getName() + " ----- threadName:" + Thread.currentThread().getName());
        return FlowRes.ok();
    }
}
