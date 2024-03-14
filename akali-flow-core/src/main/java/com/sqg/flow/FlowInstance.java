package com.sqg.flow;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.sqg.flow.config.FlowConfig;
import com.sqg.flow.config.NodeConfig;
import com.sqg.flow.enums.FlowStatusEnum;

import java.util.*;


public class FlowInstance {
    private String flowName;
    private Date startTime;
    private Map<String,Object> props;
    private List<BaseNode> baseNodes;
    private int status;

    public FlowInstance() {
        this.status = FlowStatusEnum.INIT.getStatus();
    }

    public FlowInstance createFlow(FlowConfig flowConfig){
        this.baseNodes = loadNodes(flowConfig.getNodes());
        this.flowName = flowConfig.getFlowName();
        String time = flowConfig.getStartTime();
        if (time != null && !"".equals(time)){
            DateTime parse = DateUtil.parse(time);
            this.startTime = parse.toJdkDate();
        }
        this.props = flowConfig.getProps();
        return this;
    }

    private List<BaseNode> loadNodes(List<NodeConfig> nodeConfigs) {
        LinkedList<BaseNode> baseNodeLinkedList = new LinkedList<>();
        for (NodeConfig nodeConfig : nodeConfigs) {
            BaseNode baseNode = createNode(nodeConfig);
            baseNode.setProps(nodeConfig.getProps());
            baseNode.setName(nodeConfig.getName());
            baseNodeLinkedList.add(baseNode);
        }
        return baseNodeLinkedList;
    }

    public BaseNode createNode(NodeConfig nodeConfig) {
        if (nodeConfig.getIsParallel() == 1){
            //所有的并行节点使用同一个线程池
            ParallelBaseNode parallelNode = new ParallelBaseNode(nodeConfig.getName());
            parallelNode.setNodes(loadNodes(nodeConfig.getParallelNodes()));
            return parallelNode;
        }else {
            String className = nodeConfig.getClassName();
            if (className != null && !"".equals(className)){
                return (BaseNode)instanceClass(className);
            }
            String factoryClass = nodeConfig.getFactoryClass();
            if (factoryClass != null && !"".equals(factoryClass)){
                Object o = instanceClass(factoryClass);
                NodeFactory nodeFactory = (NodeFactory) o;
                return nodeFactory.createNode(nodeConfig);
            }
            if ("printNode".equals(nodeConfig.getType())){
                return new DefaultBaseNode(nodeConfig.getName());
            }
        }
        this.end();
        throw new RuntimeException("未找到对应的节点生成方式");
    }

    public Object instanceClass(String className){
        try {
            Class<?> ClassTemplate = Class.forName(className);
            return ClassTemplate.newInstance();
        }catch (ClassNotFoundException e){
            throw new RuntimeException("找不到类：" + className);
        }catch (InstantiationException | IllegalAccessException  e){
            throw new RuntimeException("实例化类失败：" + className);
        }
    }

    public List<BaseNode> getBaseNodes() {
        return baseNodes;
    }

    public void setBaseNodes(List<BaseNode> baseNodes) {
        this.baseNodes = baseNodes;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public void setStartTime(String startTime) {
        DateTime parse = DateUtil.parse(startTime);
        this.startTime = parse.toJdkDate();
    }
    public synchronized void start() {
        assert baseNodes.size() > 0 : "节点为空";
        status = FlowStatusEnum.START.getStatus();
        for (BaseNode baseNode : baseNodes) {
            baseNode.execute(null);
            baseNode.exit();
        }
    }

    public synchronized void end() {
        status = FlowStatusEnum.END.getStatus();
    }
}
