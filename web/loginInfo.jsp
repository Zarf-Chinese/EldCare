<%-- Created by IntelliJ IDEA. User: ShiQi Date: 2019/11/2 Time: 20:04 To change
this template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%-- 展示其他页面传来的错误信息：--%> <% int loginInfo =
        (int)request.getAttribute("loginInfo"); if (loginInfo==-1) {
        out.print("登录失败,此用户名不存在"); } else if (loginInfo==0){
        out.print("登录失败，密码错误"); }else{ out.print("
        <div>登录成功</div>
        "); } %>
    </body>
</html>
