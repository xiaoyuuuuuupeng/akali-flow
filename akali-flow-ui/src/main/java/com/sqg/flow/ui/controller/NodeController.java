package com.sqg.flow.ui.controller;

import com.sqg.flow.core.BaseNode;
import com.sqg.flow.core.FlowHolder;
import com.sqg.flow.ui.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/akali/nodes")
@CrossOrigin
public class NodeController {

    private final FlowHolder flowHolder;

    public NodeController(FlowHolder flowHolder) {
        this.flowHolder = flowHolder;
    }

    @RequestMapping("/test")
    public ResultVO test(){
        return ResultVO.ok("success");
    }
    @RequestMapping("/getNodes")
    public ResultVO getNodes(){
        Map<String, BaseNode> nodeMap = flowHolder.getNodeMap();
        if (nodeMap == null || nodeMap.isEmpty()){
            return ResultVO.ok();
        }
        return ResultVO.ok(nodeMap);
    }
}
