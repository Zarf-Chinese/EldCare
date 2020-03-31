package com.eldcare.service;

import com.eldcare.mapper.ElderMapper;
import com.eldcare.mapper.NurseMapper;
import com.eldcare.model.Elder;
import com.eldcare.model.ElderExample;
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
        if(elderMapper.selectByPrimaryKey(elder.getId())!=null){
            elderMapper.updateByPrimaryKey(elder);
        }else{
            elderMapper.insert(elder);
        }
    }
    public List<Elder> list() {
        return elderMapper.selectAll();
    }

    public Elder selectById(int id) {
        return elderMapper.selectByPrimaryKey(id);
    }

    public List<Elder> listByIn(Integer id) {
        ElderExample elderExample=new ElderExample();
        elderExample.createCriteria().andBidEqualTo(id);
        return elderMapper.selectByExample(elderExample);
    }

    public void update(Elder elder) {
        elderMapper.selectByPrimaryKey(elder.getId());
        elder.setGmtModified(nowTime);
        elderMapper.updateByPrimaryKey(elder);
    }
}
