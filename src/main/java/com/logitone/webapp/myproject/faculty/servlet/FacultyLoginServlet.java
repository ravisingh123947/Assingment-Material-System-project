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
import com.logitone.webapp.myproject.faculty.service.FacultyServiceImpl;;

public class FacultyLoginServlet extends HttpServlet {
	FacultyService facultyServiceImpl = new FacultyServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Faculty faculty = facultyServiceImpl.authenticateFacultyByEmailAndPassword(username, password);
		if (faculty != null) {
			req.setAttribute("FACULTY", faculty);

			RequestDispatcher rd = req.getRequestDispatcher("./facultyAfterSignedIn.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("loginStatus", "invalid");
			RequestDispatcher rd = req.getRequestDispatcher("./facultyLogin.jsp");
			rd.forward(req, resp);
		}
	}

}
