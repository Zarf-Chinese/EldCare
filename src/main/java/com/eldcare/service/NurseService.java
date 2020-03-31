package com.eldcare.service;

import com.eldcare.mapper.NurseMapper;
import com.eldcare.model.Nurse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        if(nurseMapper.selectByPrimaryKey(nurse.getId())!=null){
            nurseMapper.updateByPrimaryKey(nurse);
        }else{
            nurseMapper.insert(nurse);
        }
    }
    public List<Nurse> list(String search) {
        //查找：
        if (StringUtils.isNotBlank(search)) {
            String[] tags = StringUtils.split(search, " ");
            //按空格拆分，拼上|，传递至数据库查找
            search = Arrays.stream(tags).collect(Collectors.joining("|"));
        }
        return nurseMapper.selectBySearch(search);
    }

    public Nurse selectById(int id) {
        return nurseMapper.selectByPrimaryKey(id);
    }

    public void update(Nurse nurse) {
        nurseMapper.selectByPrimaryKey(nurse.getId());
        nurse.setGmtModified(nowTime);
        nurseMapper.updateByPrimaryKey(nurse);
    }
}
