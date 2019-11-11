package service;

import entity.User;

/**
 * Author:ShiQi
 * Date:2019/11/11-18:16
 */
public interface IUserService {
    //查询指定id的用户是否存在
    public boolean isExist(String id);
    //新增用户
    public boolean addUser(User u);
    //根据id查询用户信息
    public User queryUserById(String id);
}
