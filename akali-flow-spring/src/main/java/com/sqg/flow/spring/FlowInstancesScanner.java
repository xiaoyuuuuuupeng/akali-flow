package com.sqg.flow.spring;

import com.sqg.flow.core.FlowHolder;
import com.sqg.flow.core.FlowInstance;
import com.sqg.flow.core.FlowInterface;
import com.sqg.flow.core.annotation.AnnotationLoader;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FlowInstancesScanner implements ApplicationContextAware {
    FlowHolder flowHolder ;
    String source ;

    public FlowInstancesScanner(FlowHolder flowHolder,String source) {
        this.flowHolder = flowHolder;
        this.source = source;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
       loadFromBean(applicationContext);
       if (!"".equals(source)){
           source = "./**";
       }
       loadFromConfig(source);
    }

    private void loadFromConfig(String source) {
        //TODO : 加载该目录下所有的flow.json

    }

    private void loadFromBean(ApplicationContext applicationContext) {
        Map<String, FlowInterface> beansOfType = applicationContext.getBeansOfType(FlowInterface.class);
        List<FlowInstance> flowInstances = new LinkedList<>();
        beansOfType.forEach((k, v) -> {
            FlowInstance flowInstance = null;
            try {
                flowInstance = AnnotationLoader.wrapperFlowInstance(v.getClass());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (flowInstance != null){
                flowInstances.add(flowInstance);
            }
        });
        if (flowHolder != null && !flowInstances.isEmpty()){
            flowHolder.putAll(flowInstances);
        }
    }


}
