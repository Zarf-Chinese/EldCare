package com.eldcare.controller;

import com.eldcare.model.User;
import com.eldcare.utils.BaseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ShiQi
 * @Date 2020/03/20 15:25
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        User currentUser= BaseUtils.instance.getCurrentUser();
        if(currentUser==null){
            //如果当前用户未登录
            return "redirect:/login";
        }
        return "redirect:/home";
    }
}
