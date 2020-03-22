package com.eldcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Zhanghe
 * @Date 20/03/22
 */
@Controller
public class IdentityController {
    @GetMapping("/identity")
    String identity(Model model){
        return "Identity";
    }
    @PostMapping(path="/identity")
    String setIdentity(@RequestParam("identityType") int identityType){
        return "Identity";
    }
}
