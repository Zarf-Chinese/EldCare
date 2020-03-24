package com.eldcare.controller;

import com.eldcare.model.Feedback;
import com.eldcare.service.FeedbackService;
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

    @GetMapping("/feedback")
    public String feed(Model model) {
        return "/Feedback";
    }
    @PostMapping("/feedback")
    public String feedback(@RequestParam(name = "nurse") int nurse,
                            @RequestParam(name="elder")int elder,
                            @RequestParam(name="score")int score,
                            @RequestParam(name="content")String content,
                           @RequestParam(name="niming")Boolean niming){
        Feedback feedback=new Feedback();
        feedback.setNurse(nurse);
        feedback.setElder(elder);
        feedback.setScore(score);
        feedback.setContent(content);
        feedback.setIsAnon(niming);
        feedbackService.create(feedback);
        return "redirect:/Home";
    }
}
