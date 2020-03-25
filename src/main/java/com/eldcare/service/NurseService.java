package com.eldcare.service;

import com.eldcare.mapper.NurseMapper;
import com.eldcare.model.Nurse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author ShiQi
 * @Date 2020/03/24 20:04
 */
@Service
public class NurseService {
    @Resource
    private NurseMapper nurseMapper;

    Long nowTime = System.currentTimeMillis();

    public void create(Nurse nurse){
        nurse.setGmtModified(nowTime);
        nurseMapper.insert(nurse);
    }
    public List<Nurse> list() {
        return nurseMapper.selectAll();
    }
}
