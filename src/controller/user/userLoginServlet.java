package controller.user;

import entity.User;
import service.IUserService;
import service.UserServiceImpl;

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

        String id=request.getParameter("uid");
        String password=request.getParameter("upwd");
        //根据id判断此人是否存在：
        IUserService ss = new UserServiceImpl();
        boolean isExist=ss.isExist(id);
        int loginInfo=-1;

        if(isExist){
            //存在
            User u=ss.queryUserById(id);
            //判断密码是否一致
            if(u.getPassword().equals(password)){
                loginInfo=1;//密码正确，登录成功
            }else{
                loginInfo=0;//密码错误
            }
        }else{
            //此人不存在
        }

        //展示给前端（有信息，转发）：
        request.setAttribute("loginInfo",loginInfo);
        request.getRequestDispatcher("loginInfo.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
