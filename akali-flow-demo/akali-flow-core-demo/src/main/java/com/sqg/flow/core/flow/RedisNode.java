package com.sqg.flow.core.flow;


import com.sqg.flow.BaseNode;

import java.util.Map;

public class RedisNode extends BaseNode {

    public RedisNode() {
    }

    public RedisNode(String name) {
        super(name);
    }

    @Override
    public Map<String,Object> execute(Map<String, Object> context) {
        System.out.println("RedisNode execute , i am "+ getName() +",开始一个进行Redis操作" + " ------- threadName:" + Thread.currentThread().getName());
        return context;
    }
}
