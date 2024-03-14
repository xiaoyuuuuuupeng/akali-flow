package com.sqg.flow;

import com.sqg.flow.config.NodeConfig;

public interface NodeFactory {

    public BaseNode createNode(NodeConfig nodeConfig);
}
