package com.sqg.flow.core.demo;

import com.sqg.flow.core.BaseNode;
import com.sqg.flow.core.FlowInterface;
import com.sqg.flow.core.ParallelBaseNode;
import com.sqg.flow.core.annotation.Flow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;


@Flow(flowName = "myFlow",startTime = "2023-12-12 12:12:12")
public class MyFlow implements FlowInterface {

    @Override
    public List<BaseNode> getNodes() {
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
        nodes.add(ParallelBaseNode);
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        reentrantLock.unlock();
        LongAdder adder = new LongAdder();
        return nodes;
    }
}
