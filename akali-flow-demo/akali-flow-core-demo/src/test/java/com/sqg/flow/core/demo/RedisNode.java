package com.sqg.flow.core.demo;


import com.sqg.flow.core.BaseNode;
import com.sqg.flow.core.model.FlowMap;
import com.sqg.flow.core.model.FlowReq;
import com.sqg.flow.core.model.FlowRes;

public class RedisNode extends BaseNode {

    public RedisNode() {
    }

    public RedisNode(String name) {
        super(name);
    }

    @Override
    public void execute() throws Exception{
        System.out.println("RedisNode execute , i am "+ getName() +",开始一个进行Redis操作" + " ------- threadName:" + Thread.currentThread().getName());
    }
}
