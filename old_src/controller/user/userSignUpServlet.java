package controller.user;

import entity.User;
import service.IUserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:ShiQi
 * Date:2019/11/11-21:49
 */
@WebServlet("/signUp.do")
public class userSignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求编码
        request.setCharacterEncoding("utf-8");
        //设置响应编码
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String id=request.getParameter("uid");
        String password=request.getParameter("upwd");
        //封装：
        User u=new User(id,password);

        IUserService ss = new UserServiceImpl();
        boolean result = ss.addUser(u);

        if (result) {
//           response.getWriter().write("新用户注册成功，3秒后跳转至登录页");
//        //跳转至其他页面
//            response.setHeader("refresh","3;/EldCare/login.html");
            response.sendRedirect("login.html");
            System.out.print("success");
           // 如果成功弹出登陆成功并跳到下一个页面
//            response.getWriter().write("<script  type='text/javascript'>alert('新用户注册成功!');window.location.href='login.html'</script>");

        }else{
//            response.getWriter().write("注册失败，此用户名已经存在");
            response.getWriter().print("<script language = javascript>alert('注册失败，此用户名已存在');window.location.href='login.html'</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}