<%--
  Created by IntelliJ IDEA.
  User: ShiQi
  Date: 2019/11/11
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  展示其他页面传来的错误信息：--%>
<%
    boolean result = (boolean)request.getAttribute("result");
    if (result) {
        out.print("新用户注册成功");
    }else{
        out.print("注册失败，此用户名已经存在");
    }
%>

</body>
</html>
