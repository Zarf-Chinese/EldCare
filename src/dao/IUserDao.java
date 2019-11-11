package dao;

import entity.User;

/**
 * Author:ShiQi
 * Date:2019/11/11-16:29
 */
public interface IUserDao {
    //判断此人是否存在：
    public boolean isExist(String id);
    //新增用户
    public boolean addUser(User u);
    //根据id查询用户信息
    public User queryUserById(String id);
}
