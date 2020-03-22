package com.eldcare.controller;

import com.eldcare.model.User;
import com.eldcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zarf
 * @since 2020-03-18
 */
@Controller
public class SignUpController {
    @Autowired
    private UserService userService;

    //get方法：渲染页面
    @GetMapping("/signUp")
    public String signUp(Model model) {
        return "/SignUp";
    }

    @PostMapping("/signUp")
    public String doSignUp(@RequestParam(name = "name") String name,
                         @RequestParam(name = "password") String password,
                         Model model) {
        //查询一下是否存在此用户
        if (userService.isExist(name)) {
            //此用户名已存在
            model.addAttribute("error", "此用户名已存在！");
            return "/SignUp";
        } else {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            userService.create(user);
            return "redirect:/login";
        }
    }
}

