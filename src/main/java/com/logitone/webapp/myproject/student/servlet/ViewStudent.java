package com.logitone.webapp.myproject.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logitone.webapp.myproject.student.dao.StudentDaoImpl;
import com.logitone.webapp.myproject.student.entity.Student;
import com.logitone.webapp.myproject.student.service.StudentService;
import com.logitone.webapp.myproject.student.service.StudentServiceImpl;

public class ViewStudent extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StudentService studentService = new StudentServiceImpl();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		Student[] students = studentService.getAllStudents();

		if (students != null) {
			req.setAttribute("status", req.getAttribute("status"));
			req.setAttribute("STUDENTLIST", students);

			RequestDispatcher rd = req.getRequestDispatcher("./viewStudent.jsp");
			rd.forward(req, resp);
//    		out.println("<p>"+students[0].getName()+"</p>");
		}
	}

}
