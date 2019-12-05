package controller.nurse;

import entity.NurComment;
import service.INurService;
import service.NurServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author:ShiQi
 * Date:2019/12/2-20:16
 */
@WebServlet("/nurShowCom.do")
public class nurShowComServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求编码
//        request.setCharacterEncoding("utf-8");
        //设置响应编码
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        INurService ns = new NurServiceImpl();
        List<NurComment> coms=ns.showCom();
        System.out.println(coms);
        //将查到的信息放入request域：
        request.setAttribute("comment",coms);
        //request域中有数据，需要通过请求转发的方式跳转。（重定向会丢失数据）
        //用session也可以，但范围越小越好（request：同一次请求有效；session：同一次会话有效）

        //查询完毕，发送至如下页面：
        request.getRequestDispatcher("familyPublicComment.jsp").forward(request,response);
    }
}
