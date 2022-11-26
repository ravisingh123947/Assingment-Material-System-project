package com.logitone.webapp.myproject.faculty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logitone.webapp.myproject.faculty.dao.FacultyDaoImpl;
import com.logitone.webapp.myproject.faculty.entity.Faculty;
import com.logitone.webapp.myproject.faculty.service.FacultyService;
import com.logitone.webapp.myproject.faculty.service.FacultyServiceImpl;

public class FacultySignUpservlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FacultyService facultyServiceImpl = new FacultyServiceImpl();

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Faculty faculty = new Faculty(id, name, email, username, password);
		boolean status = facultyServiceImpl.registerFaculty(faculty);
		if (status) {
			req.setAttribute("username", username);
			RequestDispatcher rd = req.getRequestDispatcher("./facultySignUp.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("./facultySignUp.jsp");
			rd.forward(req, resp);
		}
	}

}
