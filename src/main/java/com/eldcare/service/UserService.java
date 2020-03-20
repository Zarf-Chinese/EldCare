package com.eldcare.service;

import com.eldcare.mapper.UserMapper;
import com.eldcare.model.User;
import com.eldcare.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ShiQi
 * @Date 2020/03/20 14:18
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

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

    //重新登录时
    public void Update(User user) {
        User dbUser=userMapper.selectByPrimaryKey(user.getName());
        user.setGmtModified(nowTime);
        UserExample example = new UserExample();
        example.createCriteria()
                .andNameEqualTo(dbUser.getName());
        userMapper.updateByExampleSelective(user, example);
    }
}
