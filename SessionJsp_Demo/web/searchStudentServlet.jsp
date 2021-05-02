<%--
  Created by IntelliJ IDEA.
  User: Antone
  Date: 2021/4/27
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询页面</title>
</head>
<body>
        <div style="float: right">
            <a href="/SJ/index.jsp">返回首页</a>
        </div><br/>

<form action="/SJ/searchStudentServlet" method="post">


        <input type="text" name="name" placeholder="请输入姓名搜索" value="<%= request.getAttribute("name")==null? "" :request.getAttribute("name")%>">
        <input type="submit" value="搜索">
    </form>
    <span>
        <%= request.getAttribute("student")==null ? "" :request.getAttribute("student") %>
    </span>
</body>
</html>
