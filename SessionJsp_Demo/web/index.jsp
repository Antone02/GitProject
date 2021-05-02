<%@ page import="com.studentWebsite.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Antone
  Date: 2021/4/25
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>学生官网首页</title>
  </head>
  <body>
      <h1>学生官网首页</h1>

      <div style="float: right"><%
          User user = (User)session.getAttribute("user");
      if(user==null){

          //添加一需求，您未登录，请在登录后在操作
        /*
        //转发
        response.sendRedirect("/SJ/login.jsp");
        */

        //重定向
          request.getRequestDispatcher("/login.jsp").forward(request,response);
        return;
      }
      %>
          <%--需要先判断 session是否为null --%>
          <%=
              user.getUsername()==null ? "" : user.getUsername()
          %>,欢迎您</div>

      <a href="/SJ/loginServlet">登录</a><br/>
      <a href="/SJ/addStudentServlet.jsp">添加学生</a><br/>
      <a href="/SJ/findStudentServlet">查看所有学生</a><br/>
      <a href="/SJ/searchStudentServlet.jsp">搜索学生</a><br/>

  </body>
</html>
