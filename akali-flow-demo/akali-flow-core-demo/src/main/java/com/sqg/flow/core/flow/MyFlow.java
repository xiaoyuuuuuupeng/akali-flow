package com.sqg.flow.core.flow;

import com.sqg.flow.BaseNode;
import com.sqg.flow.FlowInterface;
import com.sqg.flow.ParallelBaseNode;
import com.sqg.flow.annotation.Flow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Flow(flowName = "myFlow",startTime = "2023-12-12 12:12:12")
public class MyFlow implements FlowInterface {

    @Override
    public List<BaseNode> getNodes(Map<String, Object> context) {
        KafkaNode kafkaNode = new KafkaNode("myFlow的kafka节点");
        RedisNode redisNode = new RedisNode("myFlow的redis节点");
        ArrayList<BaseNode> nodes = new ArrayList<>();
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        nodes.add(kafkaNode);
        nodes.add(redisNode);
        ArrayList<BaseNode> parallelNodes = new ArrayList<>();
        parallelNodes.add(kafkaNode);
        parallelNodes.add(redisNode);
        parallelNodes.add(kafkaNode);
        parallelNodes.add(redisNode);
        parallelNodes.add(kafkaNode);
        parallelNodes.add(redisNode);
        parallelNodes.add(kafkaNode);
        parallelNodes.add(redisNode);
        ParallelBaseNode ParallelBaseNode = new ParallelBaseNode("myFlow的并行节点");
        ParallelBaseNode.setNodes(parallelNodes);
        ParallelBaseNode.setProps(new HashMap<>());
        nodes.add(ParallelBaseNode);
        return nodes;
    }
}
