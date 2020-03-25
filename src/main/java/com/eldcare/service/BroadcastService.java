package com.eldcare.service;

import com.eldcare.mapper.BroadcastMapper;
import com.eldcare.model.Broadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
*
 * @Author ShiQi
 * @Date 2020/03/24 20:40

*/

@Service
public class BroadcastService {
    @Resource
    private BroadcastMapper broadcastMapper;

    Long nowTime = System.currentTimeMillis();

    public void create(Broadcast broadcast){
        broadcast.setGmtCreate(nowTime);
        broadcastMapper.insert(broadcast);
    }
}
