package com.eldcare.controller;

import com.eldcare.model.*;
import com.eldcare.service.BroadcastService;
import com.eldcare.service.ElderService;
import com.eldcare.service.ManagerService;
import com.eldcare.service.NurseService;
import com.eldcare.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    private BroadcastService broadcastService;
    @Autowired
    private NurseService nurseService;
    @Autowired
    private ElderService elderService;
    @GetMapping("/home")
    public String goHome(Model model){
        User currentUser= BaseUtils.instance.getCurrentUser();
        if(currentUser==null){
            //如果尚未登录
            return "redirect:/index";
        }
        if(currentUser.getType()==null){
            //尚未选择身份
            return "redirect:/identity";
        }
        int id=currentUser.getId();
        int type=currentUser.getType();
        //展示内容
        //院方
        if(type==1) {
            Manager manager = managerService.selectById(id);
            model.addAttribute("manager", manager);
            List<Broadcast> broadcasts = broadcastService.listByCreator(id);
            model.addAttribute("broadcasts", broadcasts);
        }
        //护工
        if(type==2) {
            Nurse nurse = nurseService.selectById(id);
            model.addAttribute("nurse",nurse);
            Manager manager=managerService.selectById(nurse.getBid());
            if(manager!=null){
                model.addAttribute("manager", manager);
                List<Broadcast> broadcasts=broadcastService.listForNurse(nurse.getBid());
                model.addAttribute("broadcasts",broadcasts);
            }
        }
        //老人
        if(type==3){
            Elder elder=elderService.selectById(id);
            model.addAttribute("elder",elder);
            Nurse nurse = nurseService.selectById(elder.getBid());
            if(nurse!=null){
                model.addAttribute("nurse",nurse);
                Manager manager=managerService.selectById(nurse.getBid());
                if(manager!=null){
                    model.addAttribute("manager", manager);
                    List<Broadcast> broadcasts=broadcastService.listForElder(nurse.getBid());
                    model.addAttribute("broadcasts",broadcasts);
                }
            }
        }
        model.addAttribute("user",currentUser);
        return "/Home";
    }
}
