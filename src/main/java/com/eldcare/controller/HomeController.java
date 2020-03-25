package com.eldcare.controller;

import com.eldcare.model.Elder;
import com.eldcare.model.Manager;
import com.eldcare.model.Nurse;
import com.eldcare.model.User;
import com.eldcare.service.ElderService;
import com.eldcare.service.ManagerService;
import com.eldcare.service.NurseService;
import com.eldcare.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author ShiQi
 * @Date 2020/03/20 17:13
 */
@Controller
public class HomeController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private NurseService nurseService;
    @Autowired
    private ElderService elderService;
    @GetMapping("/home")
    public String goHome(Model model, HttpServletResponse response){
        User currentUser= BaseUtils.instance.getCurrentUser();
        if(currentUser==null){
            //如果尚未登录
            return "redirect:/index";
        }
        if(currentUser.getType()==null){
            //尚未选择身份
            return "redirect:/identity";
        }
        //展示内容
        List<Manager> managers = managerService.list();
        model.addAttribute("managers",managers);
        List<Nurse> nurses=nurseService.list();
        model.addAttribute("nurses",nurses);
        List<Elder> elders=elderService.list();
        model.addAttribute("elders",elders);

        model.addAttribute("user",currentUser);
        return "/Home";
    }
}
