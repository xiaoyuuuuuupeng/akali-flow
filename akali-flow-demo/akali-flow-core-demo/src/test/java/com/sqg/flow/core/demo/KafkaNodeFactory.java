package com.sqg.flow.core.demo;

import com.sqg.flow.core.BaseNode;
import com.sqg.flow.core.NodeFactory;
import com.sqg.flow.core.config.NodeConfig;
import com.sqg.flow.core.model.FlowMap;

public class KafkaNodeFactory implements NodeFactory {
    @Override
    public BaseNode createNode(NodeConfig nodeConfig) {
        FlowMap flowMap = new FlowMap(nodeConfig.getProps(), true);
        return new KafkaNode(nodeConfig.getName(),flowMap);
    }
}
