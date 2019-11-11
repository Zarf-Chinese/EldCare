package service;

import dao.IUserDao;
import dao.UserDaoImpl;
import entity.User;

/**
 * Author:ShiQi
 * Date:2019/11/11-18:16
 */
public class UserServiceImpl implements IUserService {
    IUserDao userDao=new UserDaoImpl();
    //查询指定id的用户是否存在
    public boolean isExist(String id){
        return userDao.isExist(id);
    }
    //新增用户
    public boolean addUser(User u) {
        if(!userDao.isExist(u.getId())){
            userDao.addUser(u);
            return true;
        }else{
            System.out.println("此用户名已存在");
            return false;
        }
    }
    //根据id查询用户信息
    public User queryUserById(String id){
        return userDao.queryUserById(id);
    }
}
