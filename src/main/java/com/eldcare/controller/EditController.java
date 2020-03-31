package com.eldcare.controller;

import com.eldcare.mapper.NurseMapper;
import com.eldcare.model.Elder;
import com.eldcare.model.Manager;
import com.eldcare.model.Nurse;
import com.eldcare.service.ElderService;
import com.eldcare.service.ManagerService;
import com.eldcare.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author ShiQi
 * @Date 2020/03/24 19:33
 */
@Controller
public class EditController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private NurseService nurseService;
    @Autowired
    private ElderService elderService;
    @PostMapping("/edit.manager")
    public String manager(@RequestParam(name = "id") int id,
                          @RequestParam(name = "name") String name,
                          @RequestParam(name = "telephone") String telephone,
                          @RequestParam(name = "address") String address) {
        Manager manager;
        manager=managerService.selectById(id);
        if(manager==null)manager= new Manager();
        manager.setId(id);
        manager.setName(name);
        manager.setTelephone(telephone);
        manager.setAddress(address);
        managerService.create(manager);
        return "redirect:/home";
    }
    @PostMapping("/edit.nurse")
    public String nurse(@RequestParam(name = "id") int id,
                        @RequestParam(name = "name") String name,
                        @RequestParam(name = "telephone") String telephone,
                        @RequestParam(name = "workAge") int workAge){
        Nurse nurse;
        nurse=nurseService.selectById(id);
        if(nurse==null)nurse=new Nurse();
        nurse.setId(id);
        nurse.setName(name);
        nurse.setTelephone(telephone);
        nurse.setWorkAge(workAge);
        nurseService.create(nurse);
        return "redirect:/home";
    }
    @PostMapping("/edit.elder")
    public String elder(@RequestParam(name = "id") int id,
                        @RequestParam(name = "name") String name,
                        @RequestParam(name = "age") int age){
        Elder elder;
        elder=elderService.selectById(id);
        if(elder==null)elder=new Elder();
        elder.setId(id);
        elder.setName(name);
        elder.setAge(age);
        elderService.create(elder);
        return "redirect:/home";
    }

}
