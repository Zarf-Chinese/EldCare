package com.eldcare.controller;

import com.eldcare.model.Health;
import com.eldcare.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @Author ShiQi
 * @Date 2020/03/24 23:36
 */
@ControllerAdvice
public class HealthController {
    @Resource
    private HealthService healthService;

    @GetMapping("/health")
    public String feed(Model model) {
        return "/HealthUpdate";
    }
    @PostMapping("/health")
    public String feedback(@RequestParam(name = "nurse")int nurse,
                           @RequestParam(name="elder")int elder,
                           @RequestParam(name="content")String content,
                           @RequestParam(name="isAbnormal")Boolean isAbnormal){
        Health health=new Health();
        health.setNurse(nurse);
        health.setElder(elder);
        health.setContent(content);
        health.setIsAbnormal(isAbnormal);
        healthService.create(health);
        return "redirect:/HealthUpdate";
    }
}
