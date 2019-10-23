<%@ page import="entity.Elder" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ShiQi
  Date: 2019/10/23
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table border="2px">
    <tr>
      <th>编号</th>
      <th>姓名</th>
<%--      <th>生日</th>--%>
    </tr>
    <%
      //获取request域中的数据：【注意这一句的语法！！！(#‵′)】
      List<Elder> elds = (List<Elder>) request.getAttribute("elds");
      for (Elder eld:elds) {
//        for (Student stu : students) {
    %>
    <tr>
      <td><%=eld.getId()%>
      </td>
      <td><%=eld.getName()%>
      </td>
      <%--&lt;%&ndash;      删除按钮：&ndash;%&gt;
      <th><a href="http://localhost:8080/MvcTrain_AddStu/delStu.do?sno=<%=eld.get()%>">删除</a></th>--%>
    </tr>
    <%
      }
    %>
  </table>

  </body>
</html>
