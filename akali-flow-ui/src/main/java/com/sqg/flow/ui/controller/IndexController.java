package com.sqg.flow.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/akali/index")
@CrossOrigin
public class IndexController {


    @RequestMapping("/ui-config.html")
    public String index(){
        return "index.html";
    }
}
