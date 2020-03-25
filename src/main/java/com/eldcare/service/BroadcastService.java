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
    @Resource
    private ManagerMapper managerMapper;
    Long nowTime = System.currentTimeMillis();

    public void create(Broadcast broadcast){
        broadcast.setGmtCreate(nowTime);
        broadcastMapper.insert(broadcast);
    }

    /**
     * 获取某个manager所发布的所有公告
     * @param manager
     * @return
     */
    public List<Broadcast> getBroadcastFor(Manager manager){
        BroadcastExample example=new BroadcastExample();
        example.createCriteria().andCreatorEqualTo(manager.getId());
        return broadcastMapper.selectByExample(example);
    }
}
