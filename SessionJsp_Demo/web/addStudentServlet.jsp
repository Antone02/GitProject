<%--
  Created by IntelliJ IDEA.
  User: Antone
  Date: 2021/4/26
  Time: 7:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
        <div style="float: right">
            <a href="/SJ/index.jsp">返回首页</a>
        </div><br/>

<form action="/SJ/addStudentServlet" method="post">
        姓名<input type="text" name="name" placeholder="请输入姓名"> <br/>
        年龄<input type="number" name="age" placeholder="请输入年龄"> <br/>
        地址<input type="text" name="address" placeholder="请输入地址"> <br/>
        <input type="submit" value="添加">
    </form>
</body>
</html>
