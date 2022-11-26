package com.logitone.webapp.myproject.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logitone.webapp.myproject.faculty.dao.FacultyDaoImpl;
import com.logitone.webapp.myproject.student.dao.StudentDaoImpl;
import com.logitone.webapp.myproject.student.entity.Student;
import com.logitone.webapp.myproject.student.service.StudentService;
import com.logitone.webapp.myproject.student.service.StudentServiceImpl;

public class StudentSignUpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService studentServiceImpl = new StudentServiceImpl();

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Student student = new Student(id, name, email, username, password);
		boolean status = studentServiceImpl.registerStudent(student);
		if (status) {
			req.setAttribute("username", username);
			RequestDispatcher rd = req.getRequestDispatcher("./studentSignUp.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("./studentSignUp.jsp");
			rd.forward(req, resp);
		}
	}

}
