package com.studentWebsite.servlet;

import com.studentWebsite.domain.Student;
import com.studentWebsite.domain.User;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.处理乱码
        req.setCharacterEncoding("utf-8");
        //2.接收浏览器提交的数据
        Map<String, String[]> pm = req.getParameterMap();

        //3.封装到Student类
        Student student = new Student();
        try {
            BeanUtils.populate(student,pm);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        /*
        //各获取路径的方法及结果，
        System.out.println(new File("../src/com/studentWebsite/servlet/AddStudentServlet").getCanonicalPath());
        -> D:\develop\apache-tomcat-9.0.29\src\com\studentWebsite\servlet\AddStudentServlet
        System.out.println(new File("../src/com/studentWebsite/servlet/AddStudentServlet").getPath());
        -> ..\src\com\studentWebsite\servlet\AddStudentServlet
        System.out.println(new File("../src/com/studentWebsite/servlet/AddStudentServlet").getAbsolutePath());
        -> D:\develop\apache-tomcat-9.0.29\bin\..\src\com\studentWebsite\servlet\AddStudentServlet

        */
        //4.写入文件
        // 文件路径貌似只能用 绝对路径，相对路径在web中处在 项目/out/artifacts/文件夹中！！！
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("H:\\01IDEAProject\\workclass\\SessionJsp_Demo\\web\\workfiles\\student.txt",true),"utf-8"));
        br.write(student.getName()+","+student.getAge()+","+student.getAddress());
        br.newLine();
        br.close();

        //5.重定向 学生列表中。
        //req.getRequestDispatcher("/listStudent.jsp").forward(req,resp);
        resp.sendRedirect("/SJ/findStudentServlet");
    }
}
