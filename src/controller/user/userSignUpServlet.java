package controller.user;

import entity.User;
import service.IUserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:ShiQi
 * Date:2019/11/11-21:49
 */
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
        PrintWriter out = response.getWriter();

        //返回给前端信息
        request.setAttribute("result",result);
        request.getRequestDispatcher("addUserInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
