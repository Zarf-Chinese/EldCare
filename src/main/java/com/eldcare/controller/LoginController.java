package com.eldcare.controller;

import com.eldcare.model.User;
import com.eldcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        return "Login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam(name = "name") String name,
                          @RequestParam(name = "password") String password,
                          Model model,
                          //写了HttpServletRequest后，spring会自动将request放入上下文以供使用
                          HttpServletResponse response) {
        User user = new User();
        user.setName(name);
        User dbUser=userService.getByName(name);
        if(dbUser==null){
            //找不到该用户
            model.addAttribute("error", "该用户不存在！");
            return "Login";
        }
        if (dbUser.getPassword().equals(password)) {
            //登录成功，写cookie和session
            String token = UUID.randomUUID().toString();//javaJDK提供的一个自动生成主键的方法:
            user.setToken(token);
            userService.Update(user);
            // 写cookie和session
            response.addCookie(new Cookie("token", token));
            return "redirect:/home";
        } else {
            //登录失败
            model.addAttribute("error", "用户名或密码错误");
            return "Login";
        }

    }


}
