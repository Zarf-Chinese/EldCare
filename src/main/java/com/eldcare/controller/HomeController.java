package com.eldcare.controller;

import com.eldcare.model.User;
import com.eldcare.utils.BaseUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ShiQi
 * @Date 2020/03/20 17:13
 */
@Controller
public class HomeController {
    @GetMapping("/home")
    public String goHome(Model model){
        User currentUser= BaseUtils.instance.getCurrentUser();
        if(currentUser==null){
            //如果尚未登录
            return "redirect:/index";
        }
        if(currentUser.getType()==null){
            //尚未选择身份
            return "redirect:/identity";
        }
        model.addAttribute("user",currentUser);
        return "Home";
    }
}
