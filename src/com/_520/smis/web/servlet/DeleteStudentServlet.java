package com._520.smis.web.servlet;

import com._520.smis.dao.IStudentDAO;
import com._520.smis.dao.impl.StudentDAOImpl;
import com._520.smis.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/delete")
public class DeleteStudentServlet extends HttpServlet {
    IStudentDAO dao = new StudentDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求参数
        resp.setContentType("text/html;charset=utf-8");
        //调用业务方法
        Long id = Long.valueOf(req.getParameter("id"));
        dao.delete(id);
        //控制界面跳转
        resp.sendRedirect("/student/list");
    }
}
