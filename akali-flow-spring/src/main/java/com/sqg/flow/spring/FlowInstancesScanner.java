package com.sqg.flow.spring;

import cn.hutool.core.collection.ListUtil;
import com.sqg.flow.core.FlowHolder;
import com.sqg.flow.core.FlowInstance;
import com.sqg.flow.core.FlowInterface;
import com.sqg.flow.core.annotation.AnnotationLoader;
import com.sqg.flow.core.config.ConfigLoader;
import com.sqg.flow.core.config.FlowConfig;
import com.sqg.flow.core.config.JsonConfigLoader;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FlowInstancesScanner implements ApplicationContextAware {
    FlowHolder flowHolder;
    String source;
    ConfigLoader configLoader;

    public FlowInstancesScanner(FlowHolder flowHolder, String source) {
        this.flowHolder = flowHolder;
        this.source = source;
        this.configLoader = new JsonConfigLoader();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        loadFromBean(applicationContext);
        loadFromConfig();
        System.out.println("load " + flowHolder.getFlowInstances().size() + " flow");
    }

    private void loadFromConfig() {
        if (source == null || "".equals(source)) {
            return;
        }
        ArrayList<String> flowJsonConfigs = ListUtil.toList(source.split(",|;"));
        for (String flowJsonConfig : flowJsonConfigs) {
            FlowConfig load = configLoader.load(flowJsonConfig);
            FlowInstance flow = new FlowInstance().createFlow(load);
            flowHolder.addFlow(flow);
        }
    }

    private void loadFromBean(ApplicationContext applicationContext) {
        Map<String, FlowInterface> beansOfType = applicationContext.getBeansOfType(FlowInterface.class);
        if (beansOfType.isEmpty()) {
            return;
        }
        List<FlowInstance> flowInstances = new LinkedList<>();
        beansOfType.forEach((k, v) -> {
            FlowInstance flowInstance = null;
            try {
                flowInstance = AnnotationLoader.wrapperFlowInstance(v.getClass());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (flowInstance != null) {
                flowInstances.add(flowInstance);
            }
        });
        if (flowHolder != null && !flowInstances.isEmpty()) {
            flowHolder.putAll(flowInstances);
        }
    }


}
