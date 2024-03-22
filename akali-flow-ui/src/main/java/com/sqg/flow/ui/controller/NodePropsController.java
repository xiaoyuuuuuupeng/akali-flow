package com.sqg.flow.ui.controller;

import com.sqg.flow.ui.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/akali/props")
@CrossOrigin
public class NodePropsController {

    @RequestMapping("/nodes/metadata")
    public ResultVO nodesPropsMetaData(){
        return ResultVO.ok();
    }
}
