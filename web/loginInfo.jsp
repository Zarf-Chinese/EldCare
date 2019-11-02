<%--
  Created by IntelliJ IDEA.
  User: ShiQi
  Date: 2019/11/2
  Time: 20:04
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
    String loginInfo = (String)request.getAttribute("loginInfo");
    if ("false".equals(loginInfo)) {
        out.print("登录失败！");
    } else if ("true".equals(loginInfo)){
        out.print("登录成功~");
    }else{
        out.print("系统异常");
    }
%>
</body>
</html>
