package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Author:ShiQi
 * Date:2019/11/2-19:28
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求编码
        request.setCharacterEncoding("utf-8");
        //设置响应编码
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String uid=request.getParameter("uid");
        String upwd=request.getParameter("upwd");
//service层
        //dao层
        boolean loginFlag = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //JDBC代码
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eldcare?useSSL=false&serverTimezone=GMT", "root", "147852");

            String sql = "select *from t_user where id=? and password=?";
            ps = conn.prepareStatement(sql);

//            以下给占位符？传值：JDBC中所有下标从1开始
            ps.setString(1,uid);//setString会自动加''
            ps.setString(2,upwd);
//            只需编译一次，之后仅传值就可完成运行
//            此处不需要传递sql语句了：
            rs = ps.executeQuery();//再传一次会重新编译
            if (rs.next()) {
                //success
                loginFlag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //展示给前端（有信息，转发）：
        request.setAttribute("loginInfo",loginFlag);
        request.getRequestDispatcher("loginInfo.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求编码
        request.setCharacterEncoding("utf-8");
        //设置响应编码
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String uid=request.getParameter("uid");
        String upwd=request.getParameter("upwd");
//service层
        //dao层
        boolean loginFlag = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //JDBC代码
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eld_care?useSSL=false&serverTimezone=GMT", "root", "147852");

            String sql = "select *from t_user where id=? and password=?";
            ps = conn.prepareStatement(sql);

//            以下给占位符？传值：JDBC中所有下标从1开始
            ps.setString(1,uid);//setString会自动加''
            ps.setString(2,upwd);
//            只需编译一次，之后仅传值就可完成运行
//            此处不需要传递sql语句了：
            rs = ps.executeQuery();//再传一次会重新编译
            if (rs.next()) {
                //success
                loginFlag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(uid+","+upwd+","+loginFlag);
       /* //展示给前端（有信息，转发）：
        request.setAttribute("loginInfo",loginFlag);
        request.getRequestDispatcher("loginInfo.jsp").forward(request,response);*/

        if(loginFlag){
            //如果增加失败，给request加入error数据（转发）
            request.setAttribute("loginInfo","true");
        }else{
            request.setAttribute("loginInfo","false");
            //增加成功
        }
        //返回给前端信息
        request.getRequestDispatcher("loginInfo.jsp").forward(request,response);
    }
}
