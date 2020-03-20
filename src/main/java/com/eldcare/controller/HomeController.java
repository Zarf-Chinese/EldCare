package com.eldcare.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ShiQi
 * @Date 2020/03/20 17:13
 */
@Controller
public class HomeController {
    @GetMapping("/Home")
    public String home(){
        return "Home";
    }
}
