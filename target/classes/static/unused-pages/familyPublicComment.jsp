<%@ page import="entity.NurComment" %>
<%@ page import="java.util.List" %>
<%@ page import="util.DBUtil" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="entity.Nurse" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: ShiQi
  Date: 2019/12/2
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--家属端_护工评价_大众点评-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>family.public comment</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 alert-warning">
            <h3 class="text-center text-warning">&nbsp;</h3>
            <h3 class="text-center text-warning">&nbsp;</h3>
            <h3 class="text-center text-warning">EldCare</h3>
            <div class="col-md-12 btn-group btn-group-vertical btn-group-lg" role="group">
                <button style="text-align:center" class="btn btn-secondary btn-block" type="button">老人资料</button>
                <button class="btn btn-secondary btn-block" type="button">老人日常</button>
                <button class="btn btn-secondary btn-block" type="button"> 护工评价</button>
                <button class="btn btn-secondary btn-block" type="button"> 养老院情况</button>
            </div>
        </div>
        <div class="col-md-1">
            <blockquote>
                <h6 class="text-gray-dark text-center">&nbsp;</h6>
                <h6 class="text-gray-dark text-center">&nbsp;</h6>
                <h6 class="text-gray-dark text-center">&nbsp;</h6>
                <h6 class="text-gray-dark text-center"> 点评</h6>
            </blockquote>

            <div class="col-md-12 btn-group btn-group-vertical" role="group">

                <button class="btn btn-secondary  btn-block" type="button">评价</button>
                <button class="btn btn-secondary btn-group-vertical btn-block" type="button"> 投诉</button>
            </div>
        </div>
        <div class="col-md-9" align="center">
            <div class="tabbable" id="tabs-641375">
                <ul>
                    &nbsp;
                </ul>
                <ul>
                    &nbsp;
                </ul>
                <ul class="nav nav-tabs">
                    <li class="nav-item"><a class="nav-link" href="#tab1" data-toggle="tab">大众点评</a></li>
                    <li class="nav-item"><a class="nav-link active" href="#tab2" data-toggle="tab">写点评</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="panel-345978"></div>
                    <div class="tab-pane" id="tab2">
                        <p>&nbsp;</p>
                    </div>
                </div>
            </div>
            <br>
            <form method="post" name="nursecomment" class="col-11" id="form1">
                <div>
                    <h4 class="text-warning"><strong>护工大众点评</strong></h4>
                    <h5>&nbsp;</h5>
                    <div class="media-object-default">
                        <!--								以下需要接收数据库数据-->
                        <%
                            //获取request域中的数据
                            List<NurComment> coms = (List<NurComment>) request.getAttribute("comment");
                            for (NurComment com : coms) {
                                String photo="images\\"+com.getNurPhoto();
                        %>
                        <div class="media"><img src="
<%--                                                        //照片信息--%>
                                                    <%=photo%>
                                                      "  alt="placeholder image" width="250"
                            class="d-flex mr-3">
                            <div class="media-body">
                                <h5 class="mt-0">
<%--                                        //id信息--%>
                                    <%=com.getNurId()%>
                                    号护工
<%--                                    姓名--%>
                                    <%=com.getName()%>
                                    </h5>
<%--                                    //评价--%>
                                <%=com.getContent()%>
                                 <%   }
                                %>
                            </div>
                        </div>
                        <!--								以下需要接收数据库数据-->
                        <div class="media"><img src="../images/hugong_feedback.jpg" alt="placeholder image" width="250"
                                                class="d-flex mr-3">
                            <div class="media-body">
                                <h5 class="mt-0">015号护工 李莉<br>
                                </h5>
                                This is the content inside the media-body. By default the media is top-aligned. Use
                                class "align-self-center" or "align-self-end" to middle align or bottom align them,
                                respectively.
                            </div>
                        </div>
                        <!--								以下需要接收数据库数据-->
                        <div class="media"><img src="../images/hugong_feedback.jpg" alt="placeholder image" width="250"
                                                class="d-flex mr-3">
                            <div class="media-body">
                                <h5 class="mt-0">015号护工 李莉</h5>
                                This is the content inside the media-body. By default the media is top-aligned. Use
                                class "align-self-center" or "align-self-end" to middle align or bottom align them,
                                respectively.
                            </div>
                        </div>
                        <!--							结束	以上需要接收数据库数据-->
                    </div>
                    <h5>&nbsp;</h5>
                    &nbsp;
                </div>
            </form>
        </div>
    </div>
</div>

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/scripts.js"></script>
<style type="text/css">
    * {
        margin: 0;
        padding: 0;
        font-family: "微软雅黑"
    }

    ul {
        list-style: none;
    }

    /*用户评分*/
    .pingfenxitong {
        padding: 15px 0;
        width: 1200px;
        margin: 0 auto;
    }

    .pingfenList {
        float: left;
        width: 500px;
        padding-right: 20px;
    }

    .pfxtTitle {
        font-weight: bold;
        font-size: 1.2em;
        padding: 4px 0;
    }

    .pfxtText {
        line-height: 25px;
    }

    .pfxtFen {
        margin: 10px 0;
    }

    .pfxtFen li {
        float: left;
        width: 98px;
        height: 30px;
    }
</style>
</body>
</html>
