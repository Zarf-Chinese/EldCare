package dao;

import entity.User;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static jdk.nashorn.internal.objects.Global.println;

/**
 * Author:ShiQi
 * Date:2019/11/11-16:32
 */
public class UserDaoImpl implements IUserDao{
    //查询指定id的用户是否存在
    public boolean isExist(String id){
        return queryUserById(id) == null ? false : true;
    }

    //新增用户（注册，只有id和password信息）
    public boolean addUser(User u) {
        String sql = "insert into t_user(id,password)values(?,?)";
        Object[] obj = {
                u.getId(), u.getPassword()
        };
        return DBUtil.executeUpdate(sql, obj);
    }

    //根据id查询用户信息
    public User queryUserById(String id) {
        User u=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[] obj = {
                id
        };
        try {
            String sql = "select * from t_user where id=?";
            rs = DBUtil.executeQuery(sql, obj);

            if (rs.next()) {
                String password = rs.getString("password");
                int identityId = rs.getInt("identity_id");
                int type = rs.getInt("type");

                u = new User(id,password,identityId,type);
            }
            return u;
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
}
