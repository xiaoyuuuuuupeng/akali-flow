package com.sqg.flow.springboot.demo;


import com.sqg.flow.core.FlowHolder;
import com.sqg.flow.core.FlowInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

import java.util.Map;

@TestPropertySource(value = "classpath:load/application.properties")
@SpringBootTest(classes = FlowLoadTests.class)
@EnableAutoConfiguration
@ComponentScan({ "com.sqg.flow.springboot.demo" })
public class FlowLoadTests {

    @Autowired
    private FlowHolder flowHolder;
    @Test
    public void testLoad(){
        Map<String, FlowInstance> flowInstances = flowHolder.getFlowInstances();
        System.out.println(flowInstances.size());
        FlowInstance flowInstance = flowInstances.get("预约活动");
        if (flowInstance != null){
            flowInstance.start();
            flowInstance.end();
        }
    }

    @Test
    public void testLoadAll(){
        Map<String, FlowInstance> flowInstances = flowHolder.getFlowInstances();
        System.out.println(flowInstances.size());
        flowInstances.forEach((flowName, flowInstance) -> {
            System.out.println(flowName + ": start !!!");
            flowInstance.start();
            flowInstance.end();
        });
    }

    @Test
    public void testLoadFromBean(){
        Map<String, FlowInstance> flowInstances = flowHolder.getFlowInstances();
        FlowInstance flowInstance = flowInstances.get("myFlow");
        if (flowInstance != null){
            flowInstance.start();
            flowInstance.end();
        }
    }
}
