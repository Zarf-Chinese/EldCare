package controller.nurse;

import entity.NurComment;
import service.INurService;
import service.IUserService;
import service.NurServiceImpl;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:ShiQi
 * Date:2019/11/17-21:05
 */
@WebServlet("/nurCom.do")
public class nurCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求编码
        request.setCharacterEncoding("utf-8");
        //设置响应编码
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取评论内容
        String content=request.getParameter("content");
        //读取当前护工id、评价者id：
        int nurId=1;
        int famId=2;
        //封装
        NurComment nurCom=new NurComment(nurId,famId,content);

        INurService ns = new NurServiceImpl();
        boolean result = ns.addCom(nurCom);

        //设置返回页格式：
        response.setHeader("content-type","text/html;charset=utf-8");
        if (result) {
            response.getWriter().write("评价成功<br>"+nurCom.toString()+"<br><a href='familyComment.html'>返回上一页</a>");
            //跳转至其他页面
//            response.setHeader("refresh","3;/EldCare/login.html");
        }else{
            response.getWriter().write("评价失败，系统错误");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
