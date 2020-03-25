package com.eldcare.controller;

import com.eldcare.model.*;
import com.eldcare.service.ElderService;
import com.eldcare.service.HealthService;
import com.eldcare.service.NurseService;
import com.eldcare.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author ShiQi
 * @Date 2020/03/24 23:36
 */
@ControllerAdvice
public class HealthController {
    @Resource
    private HealthService healthService;
    @Autowired
    private NurseService nurseService;
    @Autowired
    private ElderService elderService;

    @GetMapping("/health")
    public String health(Model model) {
        User currentUser= BaseUtils.instance.getCurrentUser();
        //只有护工可以访问的界面
        Nurse nurse = nurseService.selectById(currentUser.getId());
        model.addAttribute("nurse",nurse);
        List<Elder> elders=elderService.listByIn(currentUser.getId());
        model.addAttribute("elders",elders);
        return "/HealthUpdate";
    }
    @PostMapping("/healthUpdate")
    public String healthUpdate(@RequestParam(name="elderIndex")int elderIndex,
                           @RequestParam(name="content")String content,
                           @RequestParam(name="isAbnormal")Boolean isAbnormal){
        User currentUser= BaseUtils.instance.getCurrentUser();
        Health health=new Health();
        health.setNurse(currentUser.getId());
        health.setElder(elderIndex);
        health.setContent(content);
        health.setIsAbnormal(isAbnormal);
        healthService.create(health);
        return "redirect:/HealthUpdate";
    }
}
