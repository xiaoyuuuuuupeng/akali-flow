package com.sqg.flow.core;

import com.sqg.flow.core.config.NodeConfig;

public interface NodeFactory {

    public BaseNode createNode(NodeConfig nodeConfig);
}
