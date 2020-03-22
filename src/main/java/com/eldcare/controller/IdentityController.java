package com.eldcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Zhanghe
 * @Date 20/03/22
 */
@Controller
public class IdentityController {
    @PostMapping(path="/identity")
    String setIdentity(@RequestParam("identityType") int identityType){
        return "Identity";
    }
}
