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
import com.logitone.webapp.myproject.student.service.StudentServiceImpl;;

public class StudentLoginServlet extends HttpServlet {

	StudentService studentServiceImpl = new StudentServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Student student = studentServiceImpl.authenticateStudentByUsernameAndPassword(username, password);
		if (student != null) {
			req.setAttribute("STUDENT", student);

			RequestDispatcher rd = req.getRequestDispatcher("./studentAfterSignedIn.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("loginStatus", "invalid");
			RequestDispatcher rd = req.getRequestDispatcher("./studentLogin.jsp");
			rd.forward(req, resp);
		}
	}

}
