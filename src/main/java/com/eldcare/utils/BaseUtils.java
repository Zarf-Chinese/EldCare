package com.eldcare.utils;

import com.eldcare.model.User;
import com.eldcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseUtils {
    public static BaseUtils instance=new BaseUtils();
    @Autowired
    UserService userService;
    public User getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        String token=null;
        for (Cookie ck :
                cookies) {
            //查找token
            if (ck.getName() == "token"){
                token= ck.getValue();
            }
        }
        if(token==null){
            return null;
        }
        //通过token查找user
        return userService.getByToken(token);
    }
}