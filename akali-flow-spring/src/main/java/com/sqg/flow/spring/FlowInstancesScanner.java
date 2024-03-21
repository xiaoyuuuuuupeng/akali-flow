package com.sqg.flow.spring;

import cn.hutool.core.collection.ListUtil;
import com.sqg.flow.core.BaseNode;
import com.sqg.flow.core.FlowHolder;
import com.sqg.flow.core.FlowInstance;
import com.sqg.flow.core.FlowInterface;
import com.sqg.flow.core.annotation.AnnotationLoader;
import com.sqg.flow.core.config.ConfigLoader;
import com.sqg.flow.core.config.FlowConfig;
import com.sqg.flow.core.config.JsonConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class FlowInstancesScanner implements ApplicationContextAware {
    FlowHolder flowHolder;
    String source;
    ConfigLoader configLoader;
    ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    private static final Logger log = LoggerFactory.getLogger(FlowInstancesScanner.class);

    public FlowInstancesScanner(FlowHolder flowHolder, String source) {
        this.flowHolder = flowHolder;
        this.source = source;
        this.configLoader = new JsonConfigLoader();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        loadNodes(applicationContext);
        loadFromBean(applicationContext);
        loadFromConfig();
        log.info("A total of {} flow were loaded", flowHolder.getFlowInstances().size());
    }

    private void loadNodes(ApplicationContext applicationContext) {
        Map<String, BaseNode> baseNodesOfType = applicationContext.getBeansOfType(BaseNode.class);
        if (baseNodesOfType.isEmpty()) {
            return;
        }
        baseNodesOfType.forEach((name, baseNode) -> {
            if (baseNode.getName() == null || "".equals(baseNode.getName())){
                baseNode.setName(name);
            }
            flowHolder.addNode(name,baseNode);
        });
    }

    private void loadFromConfig() {
        if (source == null || "".equals(source)) {
            return;
        }
        ArrayList<String> flowJsonConfigs = ListUtil.toList(source.split(",|;"));
        for (String flowJsonConfig : flowJsonConfigs) {
            try {
                Resource[] resources = resourcePatternResolver.getResources(flowJsonConfig);
                for (Resource resource : resources){
                    FlowConfig load = configLoader.load(resource.getInputStream());
                    FlowInstance flow = new FlowInstance().createFlow(flowHolder.getNodes(),load);
                    log.info("load {} flow from json config success",flow.getFlowName());
                    flowHolder.addFlow(flow);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void loadFromBean(ApplicationContext applicationContext) {
        Map<String, FlowInterface> beansOfType = applicationContext.getBeansOfType(FlowInterface.class);
        if (beansOfType.isEmpty()) {
            return;
        }
        beansOfType.forEach((k, v) -> {
            FlowInstance flow = null;
            try {
                flow = AnnotationLoader.wrapperFlowInstance(v.getClass());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (flowHolder != null && flow != null) {
                log.info("load {} flow from bean success",flow.getFlowName());
                flowHolder.addFlow(flow.getFlowName(),flow);
            }
        });

    }


}
