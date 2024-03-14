package com.sqg.flow.core.flow;

import com.sqg.flow.BaseNode;
import com.sqg.flow.NodeFactory;
import com.sqg.flow.config.NodeConfig;

public class KafkaNodeFactory implements NodeFactory {
    @Override
    public BaseNode createNode(NodeConfig nodeConfig) {
        return new KafkaNode(nodeConfig.getName(),nodeConfig.getProps());
    }
}
