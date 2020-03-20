package com.eldcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ShiQi
 * @Date 2020/03/20 15:25
 */
@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
