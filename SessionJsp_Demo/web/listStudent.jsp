<%@ page import="com.studentWebsite.domain.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Antone
  Date: 2021/4/26
  Time: 7:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看学生列表</title>
</head>
<body>
        <a style="float: right" href="/SJ/index.jsp">返回首页</a><br/>

        <table border="ipx" cellspacing="0" cellpadding="0" align="center">
            <tr>
                <th>姓名</th>
                <th>年龄</th>
                <th>地址</th>
            </tr>
            <%--学生数据--%>
            <%
            List<Student> students= (List<Student>) request.getAttribute("students");
                for (Student student : students) {
            %>
                <tr>
                    <td><%=student.getName()%></td>
                    <td><%=student.getAge()%></td>
                    <td><%=student.getAddress()%></td>
                </tr>
            <%
                }
            %>


        </table>
</body>
</html>
