package com.eldcare.service;

import com.eldcare.mapper.HealthMapper;
import com.eldcare.model.Health;
import jdk.internal.org.objectweb.asm.Handle;

import javax.annotation.Resource;

/**
 * @Author ShiQi
 * @Date 2020/03/24 23:49
 */
public class HealthService {
    @Resource
    private HealthMapper healthMapper;

    Long nowTime = System.currentTimeMillis();

    public void create(Health health){
        health.setGmtCreate(nowTime);
        healthMapper.insert(health);
    }

}
