package com.sqg.flow.core.demo;

import com.sqg.flow.core.BaseNode;
import com.sqg.flow.core.model.FlowMap;
import com.sqg.flow.core.model.FlowReq;
import com.sqg.flow.core.model.FlowRes;

public class KafkaNode extends BaseNode {

    public KafkaNode(String name) {
        super(name);
    }

    public KafkaNode(String name, FlowMap props) {
        super(name,props);


    }

    @Override
    public void execute() throws Exception{
        System.out.println("KafkaNode execute , i am "+ getName() +",开始一个进行Kafka操作" + " ------- threadName:" + Thread.currentThread().getName());
    }
}
