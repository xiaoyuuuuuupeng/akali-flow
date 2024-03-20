package com.sqg.flow.springboot.demo;


import com.sqg.flow.core.FlowHolder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(value = "classpath:application.properties")
@SpringBootTest(classes = FlowLoadTests.class)
@EnableAutoConfiguration
@ComponentScan({ "com.sqg.flow.springboot.demo" })
public class FlowLoadTests {

    @Autowired
    private FlowHolder flowHolder;
    @Test
    public void testLoad(){
        System.out.println(flowHolder.getFlowInstances().size());
    }
}
