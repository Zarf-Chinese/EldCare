package com.eldcare.controller;

import com.eldcare.model.Broadcast;
import com.eldcare.service.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
*
 * @Author ShiQi
 * @Date 2020/03/24 20:34

*/

@Controller
public class BroadcastController {
    @Autowired
    private BroadcastService broadcastService;

    @GetMapping("/broadcast")
    public String broad(Model model) {
        return "/Broadcast";
    }
    @PostMapping("/broadcast")
    public String broadcast(@RequestParam(name = "id") int id,
                            @RequestParam(name = "title") String title,
                            @RequestParam(name = "content") String content,
                            @RequestParam(name = "isForLaoRen") Boolean isForLaoRen,
                            @RequestParam(name = "isForHuGong") Boolean isForHuGong){
        Broadcast broadcast =new Broadcast();
        broadcast.setCreator(id);
        broadcast.setTitle(title);
        broadcast.setContent(content);
        int type=0;
        //1：老人家属；2：护工；3：全体
        if(isForHuGong&&isForLaoRen)type=3;
        if(isForLaoRen)type=1;
        if(isForHuGong)type=2;
        broadcast.setType(type);
        broadcastService.create(broadcast);
        return "redirect:/Home";
    }
}
