package com.sqg.flow.springboot.demo.flow;

import com.sqg.flow.core.BaseNode;
import com.sqg.flow.core.DefaultBaseNode;
import com.sqg.flow.core.FlowInterface;
import com.sqg.flow.core.annotation.Flow;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Flow(flowName = "myFlow")
public class MySpringbootFlow implements FlowInterface {

    @Override
    public List<BaseNode> getNodes() {
        List<BaseNode> baseNodes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            DefaultBaseNode defaultBaseNode = new DefaultBaseNode();
            defaultBaseNode.setName("test" + i);
            baseNodes.add(defaultBaseNode);
        }
        return baseNodes;
    }

//    @Override
//    public String getEl(){
//        return "S(test1,test2,test4,test5)";
//    }

    @Override
    public String getEl(){
        return "P(test11,test2,test4,test5)";
    }
}
