package com.studentWebsite.servlet;

import com.studentWebsite.domain.Student;
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

@WebServlet("/findStudentServlet")
public class FindStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.处理乱码
        req.setCharacterEncoding("utf-8");
        //2.读取文件封装数据
        List<Student> students = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("H:\\01IDEAProject\\workclass\\SessionJsp_Demo\\web\\workfiles\\student.txt"), "utf-8"));

        String line =null;
        while((line=br.readLine())!=null){
            //封装数据
            String[] split = line.split(",");
            Student stu=new Student(split[0],split[1],split[2]);
            students.add(stu);
        }

        //3.在request域中共享学生数据
        req.setAttribute("students",students);
        //4.转发到listStudent中
        req.getRequestDispatcher("/listStudent.jsp").forward(req,resp);
    }
}
