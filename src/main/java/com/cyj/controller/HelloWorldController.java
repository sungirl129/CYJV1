package com.cyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/4/1.
 */

@Controller
public class HelloWorldController {
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

}
