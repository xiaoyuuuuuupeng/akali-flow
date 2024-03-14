package com.sqg.flow.core.flow;

import com.sqg.flow.BaseNode;

import java.util.Map;

public class KafkaNode extends BaseNode {

    public KafkaNode(String name) {
        super(name);
    }

    public KafkaNode(String name,Map<String,Object> props) {
        super(name,props);
    }

    @Override
    public Map<String,Object> execute(Map<String, Object> context) {
        System.out.println("KafkaNode execute , i am "+ getName() +",开始一个进行Kafka操作" + " ------- threadName:" + Thread.currentThread().getName());
        return context;
    }
}
