package com.sqg.flow.core.flow;

import com.sqg.flow.FlowInstance;
import com.sqg.flow.config.FlowConfig;
import com.sqg.flow.config.JsonConfigLoader;

public class FlowDemo {

    public static void main(String[] args) {

        System.out.println("================================================================");
        System.out.println("parallelFlow");
        System.out.println("================================================================");
        JsonConfigLoader jsonConfigLoader = new JsonConfigLoader();
        FlowConfig parallelFlowConfig = jsonConfigLoader.load("ParallelFlow.json");
        FlowInstance parallelFlowInstance = new FlowInstance().createFlow(parallelFlowConfig);
        parallelFlowInstance.start();
        parallelFlowInstance.end();

        System.out.println("================================================================");
        System.out.println("mixFlow");
        System.out.println("================================================================");
        FlowConfig mixFlowConfig = jsonConfigLoader.load("MixFlow.json");
        FlowInstance mixFlowInstance = new FlowInstance().createFlow(mixFlowConfig);
        mixFlowInstance.start();
        mixFlowInstance.end();

        System.out.println("================================================================");
        System.out.println("sequenceFlow");
        System.out.println("================================================================");
        FlowConfig sequenceFlowConfig = jsonConfigLoader.load("SequenceFlow.json");
        FlowInstance sequenceFlowInstance = new FlowInstance().createFlow(sequenceFlowConfig);
        sequenceFlowInstance.start();
        sequenceFlowInstance.end();

    }
}
