package com.zjw.seckill.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 2025-06-09
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/hallo")
    public String hallo(Model model){
        model.addAttribute("name","zjw");
        return "hallo";
    }
}
