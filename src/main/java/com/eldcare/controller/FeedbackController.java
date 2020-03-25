package com.eldcare.controller;

import com.eldcare.model.Elder;
import com.eldcare.model.Feedback;
import com.eldcare.model.Nurse;
import com.eldcare.model.User;
import com.eldcare.service.ElderService;
import com.eldcare.service.FeedbackService;
import com.eldcare.service.NurseService;
import com.eldcare.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author ShiQi
 * @Date 2020/03/24 21:16
 */
@Controller
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private NurseService nurseService;
    @Autowired
    private ElderService elderService;

    @GetMapping("/feedback")
    public String feed(Model model) {
        User currentUser= BaseUtils.instance.getCurrentUser();
        Elder elder=elderService.selectById(currentUser.getId());
        Nurse nurse = nurseService.selectById(elder.getIn());
        model.addAttribute("nurse",nurse);
        return "/Feedback";
    }
    @PostMapping("/feedback")
    public String feedback(@RequestParam(name="score")int score,
                            @RequestParam(name="content")String content,
                           @RequestParam(name="niming")Boolean niming){
        User currentUser= BaseUtils.instance.getCurrentUser();
        Elder elder=elderService.selectById(currentUser.getId());
        Feedback feedback=new Feedback();
        feedback.setNurse(elder.getIn());
        feedback.setElder(currentUser.getId());
        feedback.setScore(score);
        feedback.setContent(content);
        feedback.setIsAnon(niming);
        feedbackService.create(feedback);
        return "redirect:/Home";
    }
}
