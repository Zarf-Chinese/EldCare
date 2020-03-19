package com.eldcare.controller;

import com.eldcare.entity.User;
import com.eldcare.mapper.UserMapper;
import com.eldcare.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {
    @Resource
    private UserMapper userMapper;
    @RequestMapping(method = RequestMethod.GET)
    public  String hello(Model model){
        List<User> userList=userMapper.selectList(null);
        model.addAttribute("userList",userList);
        return "TestThymeleaf";
    }
}
