package com.sqg.flow.springboot.demo.node;

import com.sqg.flow.core.BaseNode;
import org.springframework.stereotype.Component;

@Component("testNode2")
public class TestNode2 extends BaseNode {
    @Override
    public void execute() throws Exception {
        System.out.println("i am:"+ getName() + "  and be executed....");
    }
}
