package com.sqg.flow.core.flow;

import com.sqg.flow.Flow;
import com.sqg.flow.config.FlowConfig;
import com.sqg.flow.config.JsonConfigLoader;

public class FlowDemo {

    public static void main(String[] args) {

        System.out.println("================================================================");
        System.out.println("parallelFlow");
        System.out.println("================================================================");
        JsonConfigLoader jsonConfigLoader = new JsonConfigLoader();
        FlowConfig parallelFlowConfig = jsonConfigLoader.load("ParallelFlow.json");
        Flow parallelFlow = new Flow().createFlow(parallelFlowConfig);
        parallelFlow.start();
        parallelFlow.end();

        System.out.println("================================================================");
        System.out.println("mixFlow");
        System.out.println("================================================================");
        FlowConfig mixFlowConfig = jsonConfigLoader.load("MixFlow.json");
        Flow mixFlow = new Flow().createFlow(mixFlowConfig);
        mixFlow.start();
        mixFlow.end();

        System.out.println("================================================================");
        System.out.println("sequenceFlow");
        System.out.println("================================================================");
        FlowConfig sequenceFlowConfig = jsonConfigLoader.load("SequenceFlow.json");
        Flow sequenceFlow = new Flow().createFlow(sequenceFlowConfig);
        sequenceFlow.start();
        sequenceFlow.end();

    }
}
