package com.sqg.flow.core.qlexpress;

import com.ql.util.express.Operator;
import com.sqg.flow.core.BaseNode;
import com.sqg.flow.core.FlowInstance;
import com.sqg.flow.core.IFNode;
import com.sqg.flow.core.ParallelBaseNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IF extends Operator {


    @Override
    public Object executeInner(Object[] var1) throws Exception{
        Object o = var1[0];
        IFNode ifNode = null;
        FlowInstance flowInstance = new FlowInstance();
        if (IFNode.class.isAssignableFrom(o.getClass())){
            ifNode = (IFNode) o;
            flowInstance.addNode(ifNode);
        }else {
            throw new RuntimeException("IF后第一个节点必须继承ifNode");
        }

        if (var1.length == 2){
            Object o1 = var1[1];
            List<BaseNode> trueNodes = unwrapperNodeList(o1);
            List<BaseNode> falseNodes = unwrapperNodeList(null);
            ifNode.setTrueNodes(trueNodes);
            ifNode.setFalseNodes(falseNodes);
        }

        if (var1.length == 3){
            Object o1 = var1[1];
            Object o2 = var1[2];
            List<BaseNode> trueNodes = unwrapperNodeList(o1);
            List<BaseNode> falseNodes = unwrapperNodeList(o2);
            ifNode.setTrueNodes(trueNodes);
            ifNode.setFalseNodes(falseNodes);
        }

        return flowInstance;
    }

    public List<BaseNode> unwrapperNodeList(Object o){
        LinkedList<BaseNode> baseNodes = new LinkedList<>();

        if (o == null){
            return baseNodes;
        }
        if (BaseNode.class.isAssignableFrom(o.getClass())){
            baseNodes.add((BaseNode) o);
        }

        if (FlowInstance.class.isAssignableFrom(o.getClass())){
            FlowInstance flowInstance = (FlowInstance) o;
            baseNodes.addAll(flowInstance.getBaseNodes());
        }
        return baseNodes;
    }

}

