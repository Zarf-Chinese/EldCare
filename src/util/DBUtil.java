package util;


import controller.nurse.nurseUpdateServlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Author:ShiQi
 * Date:2019/10/21-3:25
 * 数据库操作方法
 */
public class DBUtil {
    // 连接数据库的路径
    private static String URL;
    // 连接数据库的用户名
    private static String USERNAME;
    // 连接数据库的密码
    private static String PASSWORD;

    private static String driver;

    // 静态块
    static {
        try {
            // 读取配置文件
            Properties prop = new Properties();
            /*
             * 这种写法是将来更加推荐的相对路径 写法。
             */
            InputStream is = DBUtil.class.getClassLoader().getResourceAsStream(
                    "config.properties");

            prop.load(is);
            is.close();
            // 获取驱动
            driver = prop.getProperty("driver");
            // 获取地址
            URL = prop.getProperty("URL");
            // 获取用户名
            USERNAME = prop.getProperty("USERNAME");
            // 获取密码
            PASSWORD = prop.getProperty("PASSWORD");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    private static final String URL = "jdbc:mysql://127.0.0.1:3306/eld_care?serverTimezone=GMT";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "147852";

    //conn、ps两个对象两方法都有；且为方便查询时关闭conn变量，提出成静态变量：
    public static Connection conn = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;

    //获取连接的数据库对象：
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        //将访问数据库的连接修改为指向数据源
//        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
     /*  远程主机测试失败，优化数据库暂缓
      try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/eldCare");
            return ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        }

      */
        //以上DBUtil还需要修改，故这里简单在最后一行加上return
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
