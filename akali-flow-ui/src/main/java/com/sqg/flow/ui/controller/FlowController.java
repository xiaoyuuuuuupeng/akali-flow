package com.sqg.flow.ui.controller;

import cn.hutool.core.map.MapUtil;
import com.sqg.flow.core.FlowHolder;
import com.sqg.flow.core.FlowInstance;
import com.sqg.flow.ui.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/akali/flow")
public class FlowController {


    private final FlowHolder flowHolder;

    public FlowController(FlowHolder flowHolder) {
        this.flowHolder = flowHolder;
    }

    @RequestMapping("/getFlows")
    public ResultVO getFlows(){
        Map<String, FlowInstance> flowInstances = flowHolder.getFlowInstances();
        if (MapUtil.isEmpty(flowInstances)){
            return ResultVO.ok();
        }
        return ResultVO.ok(flowInstances);
    }
}
