package com.eldcare.controller;

import com.eldcare.model.Feedback;
import com.eldcare.model.User;
import com.eldcare.service.FeedbackService;
import com.eldcare.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String feedback(Model model){
        User currentUser= BaseUtils.instance.getCurrentUser();
        model.addAttribute("user",currentUser);
        //展示此护工收到的未被查看的评价
        List<Feedback> feedbacks=feedbackService.listNotChecked(currentUser.getId());
        model.addAttribute("feedbacks",feedbacks);
        return "/Check";
    }
    @GetMapping("/check/{id}")
    public String fbCheck(@PathVariable(name="id")int id){
        feedbackService.check(id);
        return "/Check";
    }
}
