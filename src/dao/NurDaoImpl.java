package dao;

import entity.NurComment;
import util.DBUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:ShiQi
 * Date:2019/11/17-21:20
 */
public class NurDaoImpl implements INurDao {
    //用户添加评论至nur_comment数据库
    public boolean addCom(NurComment nurComment){
        String sql = "insert into t_nur_comment(nur_id,fam_id,content) values(?,?,?)";
      /*  //格式化当前时间
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Date time= new Date();
        String str = sdf.format(time);
        System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss格式化后的输出: "+str);*/

        Object obj[]={
                nurComment.getNurId(),
                nurComment.getFamId(),
                nurComment.getContent(),
        };
        return DBUtil.executeUpdate(sql, obj);
    }
}
