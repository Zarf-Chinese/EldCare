package com.eldcare.controller;

import com.eldcare.model.Feedback;
import com.eldcare.model.User;
import com.eldcare.service.FeedbackService;
import com.eldcare.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author ShiQi
 * @Date 2020/03/24 23:17
 */
@Controller
public class CheckController {
    @Autowired
    private FeedbackService feedbackService;
    @GetMapping("/check")
    public String goHome(Model model, HttpServletResponse response){
        //展示内容
        List<Feedback> feedbacks=feedbackService.listNotChecked();
        model.addAttribute("feedbacks",feedbacks);
        User currentUser= BaseUtils.instance.getCurrentUser();
        model.addAttribute("user",currentUser);
        return "/Home";
    }
}
