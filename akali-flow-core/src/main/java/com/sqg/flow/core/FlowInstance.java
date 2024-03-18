package com.sqg.flow.core;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.sqg.flow.core.config.FlowConfig;
import com.sqg.flow.core.config.NodeConfig;
import com.sqg.flow.core.enums.FlowStatusEnum;
import com.sqg.flow.core.model.FlowMap;
import com.sqg.flow.core.model.FlowReq;
import com.sqg.flow.core.model.FlowRes;
import com.sqg.flow.core.qlexpress.FlowElBuilder;

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

    public synchronized void start() {
        assert baseNodes.size() > 0 : "节点为空，请先初始化节点";
        status = FlowStatusEnum.START.getStatus();
        for (BaseNode baseNode : baseNodes) {
            baseNode.entry();
            FlowReq flowReq = createFlowReq(baseNode);
            FlowRes res = baseNode.execute(flowReq);
            handleFlowRes(res);
            baseNode.exit();
        }
    }
    private void handleFlowRes(FlowRes res) {

    }

    private FlowReq createFlowReq(BaseNode baseNode) {
        return FlowReq.wrap(baseNode.getProps());
    }

    public synchronized void end() {
        status = FlowStatusEnum.END.getStatus();
    }


    public FlowInstance createFlow(FlowConfig flowConfig){
        FlowInstance flowInstance = new FlowInstance();
        List<NodeConfig> nodes = flowConfig.getNodes();
        List<BaseNode> nodeInstances = loadNodes(nodes);
        if (flowConfig.getEl() != null && !"".equals(flowConfig.getEl())){
            FlowElBuilder flowElBuilder = new FlowElBuilder();
            try {
                flowInstance = flowElBuilder.buildEl(flowConfig.getEl(), nodeInstances);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        flowInstance.setBaseNodes(nodeInstances);
        flowInstance.setFlowName(flowConfig.getFlowName());
        String time = flowConfig.getStartTime();
        if (time != null && !"".equals(time)){
            DateTime parse = DateUtil.parse(time);
            flowInstance.setStartTime(parse.toJdkDate());
        }
        flowInstance.setProps(flowConfig.getProps());
        return flowInstance;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private List<BaseNode> loadNodes(List<NodeConfig> nodeConfigs) {
        LinkedList<BaseNode> baseNodeLinkedList = new LinkedList<>();
        for (NodeConfig nodeConfig : nodeConfigs) {
            BaseNode baseNode = createNode(nodeConfig);
            baseNode.setProps(new FlowMap(nodeConfig.getProps(),true));
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

    public void addNode(BaseNode node) {
        if (this.baseNodes == null){
            this.baseNodes = new LinkedList<>();
        }
        this.baseNodes.add(node);
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

}
