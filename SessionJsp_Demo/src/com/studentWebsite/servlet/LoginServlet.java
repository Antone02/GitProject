package com.studentWebsite.servlet;

import com.studentWebsite.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.处理乱码
        req.setCharacterEncoding("utf-8");
        //2.获取浏览器请求信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3.读取user.txt文件
            //建立数组用于接收文件内容
            List<User> list=new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("H:\\01IDEAProject\\workclass\\SessionJsp_Demo\\web\\workfiles\\user.txt"),"utf-8"));
        String line = null;
        while((line=br.readLine())!=null){
            //将读取到的user文件信息封装到user对象中。
            String[] split = line.split(",");
            User user = new User();
            user.setUsername(split[0].split("=")[1]);
            user.setPassword(split[1].split("=")[1]);
            list.add(user);
        }
        //4.进行比对
        User user=null;

        for (User u : list) {

            if(u.getUsername().equals(username)&&u.getPassword().equals(password)){
                user=u;
                break;
            }

        }

        /* 4.1 比对成功
                在session中共享数据
                并重定向
            4.2 比对失败 user为null。
                在session中共享错误信息
                并转发页面
         */

        //共享user数据，用于修改登录账户
        req.setAttribute("username",username);

        if(user!=null){
            //登陆成功
            //在session中共享数据
            req.getSession().setAttribute("user",user);
            //设置重定向到首页
            resp.sendRedirect("index.jsp");

        }else {
            //登陆失败
            //则在session中共享错误信息，并在登录上显示
            req.setAttribute("error","用户名或密码错误！");

            req.getRequestDispatcher("login.jsp").forward(req,resp);

            //重定向会导致用户名错误时无法给出提示
            //resp.sendRedirect("login.jsp");
        }

    }
}
