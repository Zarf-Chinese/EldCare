package com.eldcare.service;

import com.eldcare.mapper.ManagerMapper;
import com.eldcare.model.Manager;
import com.eldcare.model.ManagerExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ShiQi
 * @Date 2020/03/24 19:49
 */
@Service
public class ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    Long nowTime = System.currentTimeMillis();

    public void create(Manager manager){
        manager.setGmtModified(nowTime);
        managerMapper.insert(manager);
    }

    //展示个人信息
    public Manager selectById(int id){
        return managerMapper.selectByPrimaryKey(id);
    }
    //展示所有
    public List<Manager> list(String search) {
        //查找：
        if (StringUtils.isNotBlank(search)) {
            String[] tags = StringUtils.split(search, " ");
            //按空格拆分，拼上|，传递至数据库查找
            search = Arrays.stream(tags).collect(Collectors.joining("|"));
        }
        return managerMapper.selectBySearch(search);
    }
}
