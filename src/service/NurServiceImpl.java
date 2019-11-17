package service;

import dao.INurDao;
import dao.NurDaoImpl;
import entity.NurComment;

/**
 * Author:ShiQi
 * Date:2019/11/17-21:15
 */
public class NurServiceImpl implements INurService {
    INurDao nurDao=new NurDaoImpl();
    //用户添加评论至nur_comment数据库
    public boolean addCom(NurComment nurComment){
        return nurDao.addCom(nurComment);
    }
}
