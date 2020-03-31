package com.eldcare.controller;

import com.eldcare.model.*;
import com.eldcare.service.ElderService;
import com.eldcare.service.ManagerService;
import com.eldcare.service.NurseService;
import com.eldcare.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author ShiQi
 * @Date 2020/03/25 18:47
 */
@Controller
public class SearchController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private NurseService nurseService;
    @Autowired
    private ElderService elderService;
    @GetMapping("/search/{action}")
    public String search(Model model,
                         @PathVariable("action") int action,
                         @RequestParam(name = "criteria", required = false) String criteria){
        User currentUser = BaseUtils.instance.getCurrentUser();
        int id=currentUser.getId();
        int type=currentUser.getType();
        //护工找养老院
        if(action==1) {
           List<Manager> managers=managerService.list(criteria);
           model.addAttribute("managers",managers);
           model.addAttribute("action",action);
           model.addAttribute("criteria",criteria);
        }
        //老人找护工
        if(action==2){
            List<Nurse> nurses=nurseService.list(criteria);
            model.addAttribute("nurses",nurses);
            model.addAttribute("action",action);
            model.addAttribute("criteria",criteria);
        }
        return "/Search";
    }
    //护工绑定养老院
    @GetMapping("/bind.manager/{id}")
    public String bindM(@PathVariable(name = "id") int id) {
        User currentUser = BaseUtils.instance.getCurrentUser();
        Nurse nurse = nurseService.selectById(currentUser.getId());
        nurse.setBid(id);
        nurseService.update(nurse);
        return "redirect:/home";
    }

    //老人绑定护工
    @GetMapping("/bind.nurse/{id}")
    public String bindN(@PathVariable(name = "id") int id) {
        User currentUser = BaseUtils.instance.getCurrentUser();
        Elder elder = elderService.selectById(currentUser.getId());
        elder.setBid(id);
        elderService.update(elder);
        return "redirect:/home";
    }

}
