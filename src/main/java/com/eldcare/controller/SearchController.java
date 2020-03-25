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
    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(name = "search", required = false) String search){
        User currentUser = BaseUtils.instance.getCurrentUser();
        int id=currentUser.getId();
        int type=currentUser.getType();
        //护工
        if(type==2) {
           List<Manager> managers=managerService.list(search);
           model.addAttribute("managers",managers);
        }
        //老人
        if(type==3){
            List<Nurse> nurses=nurseService.list(search);
            model.addAttribute("nurses",nurses);
        }
        return "/Search";
    }
    //护工绑定养老院
    @GetMapping("/bind.manager")
    public String bindM(@RequestParam(name = "id") int id) {
        User currentUser = BaseUtils.instance.getCurrentUser();
        Nurse nurse = nurseService.selectById(currentUser.getId());
        nurse.setIn(id);
        nurseService.update(nurse);
        return "/Search";
    }

    //老人绑定护工
    @GetMapping("/bind.nurse")
    public String bindN(@RequestParam(name = "id") int id) {
        User currentUser = BaseUtils.instance.getCurrentUser();
        Elder elder = elderService.selectById(currentUser.getId());
        elder.setIn(id);
        elderService.update(elder);
        return "/Search";
    }

}
