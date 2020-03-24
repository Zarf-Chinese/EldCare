package com.eldcare.service;

import com.eldcare.mapper.ElderMapper;
import com.eldcare.mapper.NurseMapper;
import com.eldcare.model.Elder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author ShiQi
 * @Date 2020/03/24 20:11
 */
@Service
public class ElderService {
    @Resource
    private ElderMapper elderMapper;

    Long nowTime = System.currentTimeMillis();

    public void create(Elder elder){
        elder.setGmtModified(nowTime);
        elderMapper.insert(elder);
    }
    public List<Elder> list() {
        return elderMapper.selectAll();
    }
}
