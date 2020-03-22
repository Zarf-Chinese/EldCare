package com.eldcare.controller;

import com.eldcare.model.User;
import com.eldcare.service.UserService;
import com.eldcare.utils.BaseUtils;
import com.eldcare.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Zhanghe
 * @Date 20/03/22
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/delete")
    String deleteUser() {
        User user = BaseUtils.instance.getCurrentUser();
        if (user != null) {
            userService.Delete(user);
        }
        return "redirect:/logout";
    }

    @PostMapping("/logout")
    String logoutUser(HttpServletResponse response) {
        User user = BaseUtils.instance.getCurrentUser();
        if (user != null) {
            user.setToken(null);
            userService.Update(user);
        }
        CookieUtils.set(response, CookieUtils.TOKEN,null, 0);
        return "redirect:/";
    }
}
