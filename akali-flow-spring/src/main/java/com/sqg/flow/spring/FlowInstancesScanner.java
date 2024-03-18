package com.sqg.flow.spring;

import com.sqg.flow.core.FlowHolder;
import com.sqg.flow.core.FlowInstance;
import com.sqg.flow.core.FlowInterface;
import com.sqg.flow.core.annotation.AnnotationLoader;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;
import java.util.Map;

public class FlowInstancesScanner implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        Map<String, FlowInterface> beansOfType = applicationContext.getBeansOfType(FlowInterface.class);
        FlowHolder flowHolder = applicationContext.getBean(FlowHolder.class);
        List<FlowInstance> flowInstances = null;
            beansOfType.forEach((k, v) -> {
                FlowInstance flowInstance = null;
                try {
                    flowInstance = AnnotationLoader.wrapperFlowInstance(v.getClass());
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (flowInstance != null){
                    flowInstances.add(flowInstance);
                }
        });
        if (flowHolder != null && flowInstances != null){
            flowHolder.setFlows(flowInstances);
        }
    }


}
