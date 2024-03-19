package com.sqg.flow.core.qlexpress;
import com.ql.util.express.Operator;
import com.sqg.flow.core.BaseNode;
import com.sqg.flow.core.FlowInstance;
import com.sqg.flow.core.ParallelBaseNode;

import java.util.ArrayList;
import java.util.List;

public class Parallel extends Operator{

    @Override
    public Object executeInner(Object[] var1) throws Exception{
        FlowInstance flowInstance = new FlowInstance();
        ParallelBaseNode parallelBaseNode = new ParallelBaseNode();
        ArrayList<BaseNode> baseNodes = new ArrayList<>();
        for (Object obj : var1) {
            if (BaseNode.class.isAssignableFrom(obj.getClass())){
                baseNodes.add((BaseNode) obj);
            }else if (FlowInstance.class.isAssignableFrom(obj.getClass())){
                baseNodes.addAll(((FlowInstance) obj).getBaseNodes());
            }else {
                throw new Exception("节点类型错误");
            }
        }
        parallelBaseNode.setNodes(baseNodes);
        flowInstance.addNode(parallelBaseNode);

        return flowInstance;
    }
}
