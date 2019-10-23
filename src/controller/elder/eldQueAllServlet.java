package controller.elder;

import entity.Elder;
import service.EldServiceImpl;
import service.IEldService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author:ShiQi
 * Date:2019/10/23-19:15
 */
public class eldQueAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求编码
//        request.setCharacterEncoding("utf-8");
        //设置响应编码
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        IEldService ss = new EldServiceImpl();
        List<Elder> elds=ss.queAllEld();
        System.out.println(elds);
        //将查到的信息放入request域：
        request.setAttribute("elds",elds);
        //request域中有数据，需要通过请求转发的方式跳转。（重定向会丢失数据）
        //用session也可以，但范围越小越好（request：同一次请求有效；session：同一次会话有效）

        //查询完毕，发送至如下页面：
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
