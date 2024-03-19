package com.sqg.flow.core.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.sqg.flow.core.BaseNode;
import com.sqg.flow.core.FlowInstance;
import com.sqg.flow.core.constants.QLEConstant;

import java.util.ArrayList;
import java.util.List;

public class FlowElBuilder {

    /**
     * QL解析引擎
     */
    public final static ExpressRunner RUNNER = new ExpressRunner();

    static {
        // 初始化QLExpress的Runner
        RUNNER.addFunction(QLEConstant.PARALLEL, new Parallel());
        RUNNER.addFunction(QLEConstant.P, new Parallel());
        RUNNER.addFunction(QLEConstant.SEQUENCE, new Sequence());
        RUNNER.addFunction(QLEConstant.S, new Sequence());
        RUNNER.addFunction(QLEConstant.IF, new IF());
    }


    public FlowInstance buildEl(String el, List<BaseNode> nodes) throws Exception{
        List<String> errorList = new ArrayList<>();
        DefaultContext<String, Object> context = new DefaultContext<>();
        for (BaseNode node : nodes) {
            context.put(node.getName(), node);
        }
        FlowInstance execute = (FlowInstance)RUNNER.execute(el, context, errorList, true, true);
        return execute;
    }
}
