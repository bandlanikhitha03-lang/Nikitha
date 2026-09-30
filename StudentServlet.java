package com.example.controller;

import com.example.dao.StudentDAO;
import com.example.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private final StudentDAO dao = new StudentDAO();
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        String action=req.getParameter("action");
        try {
            if("delete".equals(action)) { dao.delete(Integer.parseInt(req.getParameter("id"))); resp.sendRedirect(req.getContextPath()+"/students"); return; }
            req.setAttribute("students",dao.findAll());
            req.getRequestDispatcher("/WEB-INF/views/students.jsp").forward(req,resp);
        } catch(Exception e){ throw new ServletException(e); }
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            String id=req.getParameter("id");
            Student s=new Student(); s.setName(req.getParameter("name")); s.setEmail(req.getParameter("email")); s.setCourse(req.getParameter("course")); s.setAge(Integer.parseInt(req.getParameter("age")));
            if(id==null || id.isBlank()) dao.save(s); else { s.setId(Integer.parseInt(id)); dao.update(s); }
            resp.sendRedirect(req.getContextPath()+"/students");
        } catch(Exception e){ throw new ServletException(e); }
    }
}
