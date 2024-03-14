package com.sqg.flow;

import java.util.List;
import java.util.Map;

public interface FlowInterface {
    public  List<BaseNode> getNodes(Map<String,Object> context);
}
