package util;


import java.sql.*;

/**
 * Author:ShiQi
 * Date:2019/10/21-3:25
 * 数据库操作方法
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/eld_care?serverTimezone=GMT";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "147852";

    //conn、ps两个对象两方法都有；且为方便查询时关闭conn变量，提出成静态变量：
    public static Connection conn = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;

    //获取连接的数据库对象：
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //操作PrepareStatement：
    public static PreparedStatement createPS(String sql, Object[] obj) throws ClassNotFoundException, SQLException {
        ps = getConnection().prepareStatement(sql);
        //不需要参数的查询会报空指针异常：
        if (obj != null) {
            //?的个数与数组长度一致
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
        }
        return ps;
    }

    //通用的增删改:传入sql语句和参数值
    //需要类名.方法名直接调用，加static设置为静态方法
    public static boolean executeUpdate(String sql, Object[] obj) {
        try {
            ps = createPS(sql, obj);
            //返回的数据行数：
            int count = ps.executeUpdate();
            //成功true
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源：
            closeAll(null, ps, conn);
        }
        return false;
    }

    //通用内容查询：传入sql和参数值，返回ResultSet结果集（这里不能关闭资源~）
    public static ResultSet executeQuery(String sql, Object[] obj) {
        try {
            ps = createPS(sql, obj);
            rs = ps.executeQuery();

            return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
       /* } finally {
           *//* try {
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
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
    }
    //查询总数：
    public static int getTotalCount(String sql){
        int count =-1;//默认总数据量-1
        try {
            ps=createPS(sql,null);//最上方已定义过
            rs=ps.executeQuery();
            if(rs.next()){
                count=rs.getInt(1);
                //getInt（）方法：检索当前行中指定列的值；若该列的int值为null，则返回0；
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            closeAll(rs,ps,null);
        }
        return count;
    }

    //关闭资源(考虑到继承关系，这里关闭Statement)
    public static void closeAll(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
