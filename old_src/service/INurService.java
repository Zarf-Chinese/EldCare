package service;

import entity.NurComment;
import entity.Nurse;

import java.util.List;

/**
 * Author:ShiQi
 * Date:2019/11/17-21:15
 */
public interface INurService {
    //用户添加评论至nur_comment数据库
    public boolean addCom(NurComment nurComment);
    //护工更新信息
    public boolean nurUpdate(Nurse nurse);
    //查询护工评价信息
    public List<NurComment> showCom();
}
