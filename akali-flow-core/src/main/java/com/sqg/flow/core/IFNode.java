package com.sqg.flow.core;


import java.util.LinkedList;
import java.util.List;

public abstract class IFNode extends BaseNode{
    private List<BaseNode> trueNodes;
    private List<BaseNode> falseNodes;
    @Override
    public void execute() throws Exception {
        try {
           boolean b = this.processIf();
           if(b){
               this.executeNodes(trueNodes);
           }else {
               this.executeNodes(falseNodes);
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void executeNodes(List<BaseNode> nodes) throws Exception {
        for (BaseNode node : nodes) {
             node.execute();
        }
    }

    public abstract boolean processIf() throws Exception;

    public List<BaseNode> getTrueNodes() {
        return trueNodes;
    }

    public void setTrueNodes(List<BaseNode> trueNodes) {
        this.trueNodes = trueNodes;
    }

    public List<BaseNode> getFalseNodes() {
        return falseNodes;
    }

    public void setFalseNodes(List<BaseNode> falseNodes) {
        this.falseNodes = falseNodes;
    }

    public void addTrueNode(BaseNode node){
        if (this.trueNodes == null){
            this.trueNodes = new LinkedList<>();
        }
        this.trueNodes.add(node);
    }

    public void addFalseNode(BaseNode node){
        if (this.falseNodes == null){
            this.falseNodes = new LinkedList<>();
        }
        this.falseNodes.add(node);
    }
}
