package com.sqg.flow.core.flow;

import com.sqg.flow.FlowInstance;
import com.sqg.flow.annotation.AnnotationLoader;

import java.util.HashMap;
import java.util.List;

public class FlowDemo2 {

    public static void main(String[] args) {
        AnnotationLoader annotationLoader = new AnnotationLoader();
        List<FlowInstance> flowInstances = annotationLoader.loadFlowInstances("com.sqg.flow", new HashMap<>());
        for (FlowInstance flowInstance : flowInstances) {
            flowInstance.start();
            flowInstance.end();
        }
    }
}
