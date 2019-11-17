package service;

import entity.NurComment;

/**
 * Author:ShiQi
 * Date:2019/11/17-21:15
 */
public interface INurService {
    //用户添加评论至nur_comment数据库
    public boolean addCom(NurComment nurComment);
}
