package com.eldcare.utils;

import com.eldcare.model.User;
import com.eldcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class BaseUtils {
    public static BaseUtils instance;
    @PostConstruct
    void init(){
        instance=this;
    }

    @Autowired
    UserService userService;
    public HttpServletRequest getCurrentRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
    public Cookie getTokenCookie(){
        HttpServletRequest request = getCurrentRequest();
        return CookieUtils.get(request,CookieUtils.TOKEN);
    }
    public User getCurrentUser(){
        Cookie tokenCookie=getTokenCookie ();
        if(tokenCookie==null || tokenCookie.getValue()==null){
            return null;
        }
        //通过token查找user
        return userService.getByToken(tokenCookie.getValue());
    }
}
