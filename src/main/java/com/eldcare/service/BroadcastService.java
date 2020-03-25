package com.eldcare.service;

import com.eldcare.mapper.BroadcastMapper;
import com.eldcare.mapper.ManagerMapper;
import com.eldcare.model.Broadcast;
import com.eldcare.model.BroadcastExample;
import com.eldcare.model.Manager;
import com.eldcare.model.Nurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
*
 * @Author ShiQi
 * @Date 2020/03/24 20:40

*/

@Service
public class BroadcastService {
    @Resource
    private BroadcastMapper broadcastMapper;
    @Autowired
    private BroadcastService broadcastService;
    Long nowTime = System.currentTimeMillis();

    public void create(Broadcast broadcast){
        broadcast.setGmtCreate(nowTime);
        broadcastMapper.insert(broadcast);
    }

    /**
     * 获取某个manager所发布的所有公告
     */
    public List<Broadcast> listByCreator(int id){
        BroadcastExample broadcastExample=new BroadcastExample();
        broadcastExample.createCriteria().andCreatorEqualTo(id);
        return broadcastMapper.selectByExample(broadcastExample);
    }

    //某个养老院展示给护工的公告
    public List<Broadcast> listForNurse(int id){
        List<Broadcast> broadcasts=broadcastService.listByCreator(id);
        List<Broadcast> bforNurse = null;
        for(Broadcast broadcast:broadcasts){
            if(broadcast.getType()==2||broadcast.getType()==3)
                bforNurse.add(broadcast);
        }
        return bforNurse;
    }
    //给老人
    public List<Broadcast> listForElder(int id) {
        List<Broadcast> broadcasts=broadcastService.listByCreator(id);
        List<Broadcast> bforElder = null;
        for(Broadcast broadcast:broadcasts){
            if(broadcast.getType()==1||broadcast.getType()==3)
                bforElder.add(broadcast);
        }
        return bforElder;
    }
}
