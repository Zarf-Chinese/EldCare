package com.eldcare.service;

import com.eldcare.mapper.UserMapper;
import com.eldcare.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author ShiQi
 * @Date 2020/03/20 14:18
 */
@Service
public class UserService {
    @Resource
    private ManagerService managerService;
    @Resource
    private NurseService nurseService;
    @Resource
    private ElderService elderService;
    @Resource
    private UserMapper userMapper;
    public boolean hasIdentity(User user){
        int type=user.getType();
        return (type>1 && type<=3);
    }

    //查询此用户名是否存在
    public boolean isExist(String name) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    //登录验证
    public User getByName(String name) {
        User user = userMapper.selectByPrimaryKey(name);
        return user;
    }

    Long nowTime = System.currentTimeMillis();
    //注册
    public void create(User user) {
        user.setGmtCreate(nowTime);
        user.setGmtModified(nowTime);
        userMapper.insert(user);
    }
    public void initAsType(User user,int type){
        if(type==1){
            //作为院方初始化
            Manager manager=new Manager();
            manager.setId(user.getId());
            managerService.create(manager);
        }
        else if(type==2){
            //作为护工初始化
            Nurse nurse=new Nurse();
            nurse.setId(user.getId());
            nurseService.create(nurse);
        }else if(type==3){
            //作为护工初始化
            Elder elder=new Elder();
            elder.setId(user.getId());
            elderService.create(elder);
        }
        user.setType(type);
    }
    //重新登录时
    public void Update(User user) {
        User dbUser=userMapper.selectByPrimaryKey(user.getName());
        user.setGmtModified(nowTime);
        UserExample example = new UserExample();
        example.createCriteria()
                .andNameEqualTo(dbUser.getName());
        userMapper.updateByExampleSelective(user, example);
    }
    public void Delete(User user){
        userMapper.deleteByPrimaryKey(user.getName());
    }
    /**
     * 通过token获取User
     * @param token （缓存）登录时凭证
     * @return
     */
    public User getByToken(String token){
        UserExample userExample=new UserExample();
        userExample.createCriteria().andTokenEqualTo(token);
        List<User> results=userMapper.selectByExample(userExample);
        if(results.size()==0){
            return null;
        }
        return results.get(0);
    }
}
