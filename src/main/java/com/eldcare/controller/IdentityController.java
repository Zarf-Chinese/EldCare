package com.eldcare.controller;

import com.eldcare.model.User;
import com.eldcare.service.UserService;
import com.eldcare.utils.BaseUtils;
import com.sun.javafx.geom.transform.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Zhanghe
 * @Date 20/03/22
 */
@Controller
public class IdentityController {
    @Autowired
    UserService userService;
    @GetMapping("/identity")
    String identity(Model model){
        User currentUser= BaseUtils.instance.getCurrentUser();
        if(currentUser==null){
            //如果尚未登录
            return "redirect:/index";
        }
        return "Identity";
    }

    /**
     * 修改用户类型
     * @param identityType
     * @return
     */
    @GetMapping(path="/identity/{identityType}")
    String setIdentity(@PathVariable("identityType") int identityType,Model model){
        User currentUser= BaseUtils.instance.getCurrentUser();
        if(currentUser==null){
            System.out.print("尚未登录");
            //如果尚未登录
            return "redirect:/index";
        }
        if(identityType<1||identityType>3){
            //用户类型不合法
            model.addAttribute("error,用户类型不存在");
            return "/Identity";
        }
        //设置用户类型
        currentUser.setType(identityType);
        userService.Update(currentUser);
        return "redirect:/home";
    }
}
