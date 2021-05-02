package com.studentWebsite.servlet;

import com.studentWebsite.domain.Student;

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

@WebServlet("/searchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.修改乱码
        req.setCharacterEncoding("utf-8");
        //2.接收处理浏览器参数name
        String name = req.getParameter("name");
        //3.读取student.txt

        List<Student> students = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("H:\\01IDEAProject\\workclass\\SessionJsp_Demo\\web\\workfiles\\student.txt"), "utf-8"));

        String line = null;
        while ((line = br.readLine()) != null) {
            //封装数据
            String[] split = line.split(",");
            Student stu = new Student(split[0], split[1], split[2]);
            students.add(stu);
        }

        //4.与浏览器参数进行比对
        Student stu = null;
        //遍历students，如果比对成功则赋值。
        for (Student student : students) {
            if (student.getName().equals(name)) {
                stu = student;
                break;
            }
        }

        req.setAttribute("name",name);
        //不为null的话，就是比对成功
        if (stu != null) {
            //比对成功，
            //往request中放入共享数据   student+学生数据
            //转发到SearchStudent.jsp中

            req.setAttribute("student", stu.getName() + "," + stu.getAge() + "," + stu.getAddress());

            req.getRequestDispatcher("/searchStudentServlet.jsp").forward(req,resp);
        } else {
            //比对失败
            //往request中放入共享数据   查无此学生，请重新搜索。
            //转发到SearchStudent.jsp中

            req.setAttribute("student","查无此学生，请重新搜索");
            req.getRequestDispatcher("/searchStudentServlet.jsp").forward(req,resp);
        }


        //比对成功，
        //往request中放入共享数据   student+学生数据
        //转发到SearchStudent.jsp中

        //比对失败
        //往request中放入共享数据   查无此学生，请重新搜索。
        //转发到SearchStudent.jsp中
    }
}
