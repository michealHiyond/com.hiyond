package com.hiyond.web.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("common")
public class CommonController {

    @RequestMapping("index")
    public Object index() {
        return "common/index";
    }

    @RequestMapping("error")
    public Object error() {
        return "common/error";
    }

}
