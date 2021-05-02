<%--
  Created by IntelliJ IDEA.
  User: Antone
  Date: 2021/4/25
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <span style="color: red">
        <%--
        if user为空，则请登录
                user为有，则user 已登录
                        erroe为空 则 “”
                                error有，则error
        未实现！！！
                                --%>

        <%--
        <%
        if(request.getAttribute("user")==null){
            %>
             sout
            <%
        }else if(request.getAttribute("user")!==null){
            %>
            <dir>尊敬的request.getAttribute("user") 用户，您已登陆！</dir>
            <%
        }else if(request.getAttribute("error")==null){
            %>

            <%
        }else {
            %>
            request.getAttribute("error");
            <%
        }
        %>
        --%>

        <%= request.getAttribute("error")==null ? "" :request.getAttribute("error") %>
    </span>

    <form action="/SJ/loginServlet" method="post">
        用户名<input type="text" name="username" placeholder="请输入用户名" value="<%= request.getAttribute("username")==null?"":request.getAttribute("username")%>"/> <br/>
        密码<input type="password" name="password" placeholder="请输入密码"/> <br/>
        <input type="submit" value="登录">
    </form>

</body>
</html>
