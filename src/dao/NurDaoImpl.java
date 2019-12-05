package dao;

import entity.NurComment;
import entity.Nurse;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    //护工更新信息
    public boolean nurUpdate(Nurse nurse){
        String sql="update t_nurse set photo=? where id=?";//测试版，只做了上传照片
        Object obj[]={
                nurse.getNurPhoto(),
                nurse.getId(),
        };
        return DBUtil.executeUpdate(sql,obj);
    }
    //根据id查询护工信息
    public Nurse queNurById(int id) {
        Nurse n=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[] obj = {
                id
        };
        try {
            String sql = "select * from t_nurse where id=?";
            rs = DBUtil.executeQuery(sql, obj);

            if (rs.next()) {
                /** 护工姓名 */
               String name=rs.getString("name");
                /** 所在养老院id */
                int nurHomeId=rs.getInt("nur_home_id");
                /**
                 * 所有负责的老人id，以 ',' 间隔。如 "123,245,555"
                 */
                String elderIdList=rs.getString("elder_id_list");
                /** 护工工作时的联系方式 */
                String telNumber=rs.getString("tel_number");
                /**个人照片路径*/
               String nurPhoto=rs.getString("photo");

                n = new Nurse(id,name,nurHomeId,elderIdList,telNumber,nurPhoto);
            }
            return n;
            //删除ClassNoFoundException
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeAll(rs, ps, DBUtil.conn);
        }
    }

    //查询护工评价信息
    public List<NurComment> showCom(){
        List<NurComment> coms = new ArrayList<>();
        NurComment com=new NurComment();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from t_nur_comment";

            rs = DBUtil.executeQuery(sql, null);
//            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("nur_id");
                String content = rs.getString("content");
                //查找照片、姓名信息
                String name=queNurById(id).getName();
                String nurPhoto=queNurById(id).getNurPhoto();
                com=new NurComment(id,name,content,nurPhoto);
                coms.add(com);
            }
            return coms;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                //可以关闭conn对象了
                if (DBUtil.conn != null) {
                    DBUtil.conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
