package com.sqg.flow.core.demo;

import com.sqg.flow.core.FlowInstance;
import com.sqg.flow.core.annotation.AnnotationLoader;
import com.sqg.flow.core.config.FlowConfig;
import com.sqg.flow.core.config.JsonConfigLoader;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class FlowCoreTests {

    @Test
    public void testOne(){

        System.out.println("=========================================================================================");
        System.out.println("parallelFlow");
        System.out.println("=========================================================================================");
        JsonConfigLoader jsonConfigLoader = new JsonConfigLoader();
        FlowConfig parallelFlowConfig = jsonConfigLoader.load("ParallelFlow.json");
        FlowInstance parallelFlowInstance = new FlowInstance().createFlow(parallelFlowConfig);
        parallelFlowInstance.start();
        parallelFlowInstance.end();

        System.out.println("=========================================================================================");
        System.out.println("mixFlow");
        System.out.println("=========================================================================================");
        FlowConfig mixFlowConfig = jsonConfigLoader.load("MixFlow.json");
        FlowInstance mixFlowInstance = new FlowInstance().createFlow(mixFlowConfig);
        mixFlowInstance.start();
        mixFlowInstance.end();

        System.out.println("=========================================================================================");
        System.out.println("sequenceFlow");
        System.out.println("=========================================================================================");
        FlowConfig sequenceFlowConfig = jsonConfigLoader.load("SequenceFlow.json");
        FlowInstance sequenceFlowInstance = new FlowInstance().createFlow(sequenceFlowConfig);
        sequenceFlowInstance.start();
        sequenceFlowInstance.end();

    }

    @Test
    public void testAnnotation() throws Exception {
        AnnotationLoader annotationLoader = new AnnotationLoader();
        List<FlowInstance> flowInstances = annotationLoader.loadFlowInstances("com.sqg.flow");
        for (FlowInstance flowInstance : flowInstances) {
            flowInstance.start();
            flowInstance.end();
        }
    }
    @Test
    public void testEL() throws Exception {
        System.out.println("=========================================================================================");
        System.out.println("EL-FLOW");
        System.out.println("=========================================================================================");
        JsonConfigLoader jsonConfigLoader = new JsonConfigLoader();
        FlowConfig parallelFlowConfig = jsonConfigLoader.load("flow1.json");
        FlowInstance parallelFlowInstance = new FlowInstance().createFlow(parallelFlowConfig);
        parallelFlowInstance.start();
        parallelFlowInstance.end();
    }

    @Test
    public void testIF() throws Exception {
        System.out.println("=========================================================================================");
        System.out.println("IF-FLOW");
        System.out.println("=========================================================================================");
        JsonConfigLoader jsonConfigLoader = new JsonConfigLoader();
        FlowConfig parallelFlowConfig = jsonConfigLoader.load("ifFlow.json");
        FlowInstance parallelFlowInstance = new FlowInstance().createFlow(parallelFlowConfig);
        parallelFlowInstance.start();
        parallelFlowInstance.end();
    }

    @Test
    public void testRandom() throws Exception {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int i1 = random.nextInt(1000000);
            String s = String.format("%06d", i1  );
            System.out.println(s);
        }
    }
}
