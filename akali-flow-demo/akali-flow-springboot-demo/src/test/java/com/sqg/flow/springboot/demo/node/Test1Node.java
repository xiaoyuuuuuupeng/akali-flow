package com.sqg.flow.springboot.demo.node;

import com.sqg.flow.core.BaseNode;

public class Test1Node extends BaseNode {
    @Override
    public void execute() throws Exception {
        System.out.println("i am:"+ getName() + "  and be executed....");
    }
}
