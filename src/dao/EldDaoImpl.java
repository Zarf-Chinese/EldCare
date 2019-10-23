package dao;

import entity.Elder;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:ShiQi
 * Date:2019/10/23-19:23
 */
public class EldDaoImpl implements IEldDao {
    //显示所有老人信息
    public List<Elder> queAllEld() {
        List<Elder> elds = new ArrayList<>();
        Elder eld=new Elder();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from t_elder";

            rs = DBUtil.executeQuery(sql, null);
//            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String nurHomeId = rs.getString("nur_home_id");
                String birthdayTime = rs.getString("birthday_time");
                String state = rs.getString("state");
                eld = new Elder(id, name, nurHomeId, birthdayTime, state);
                elds.add(eld);
            }
            return elds;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
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
