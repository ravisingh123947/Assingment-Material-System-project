package com.logitone.webapp.myproject.faculty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FacultyLinkControllerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;

		String linkName = req.getParameter("link");

		if (linkName.equals("home")) {
			rd = req.getRequestDispatcher("./index.jsp");
		} else if (linkName.equals("adminLogin")) {
			rd = req.getRequestDispatcher("./adminLogin.jsp");
		} else if (linkName.equals("facultyLogin")) {
			rd = req.getRequestDispatcher("./facultyLogin.jsp");
		} else if (linkName.equals("studentLogin")) {
			rd = req.getRequestDispatcher("./studentLogin.jsp");
		} else if (linkName.equals("logOut")) {
			HttpSession session = req.getSession();
			session.removeAttribute("FACULTYNAME");
			session.removeAttribute("FACULTYID");
			rd = req.getRequestDispatcher("./studentLogin.jsp");
		} else if (linkName.equals("uploadMaterial")) {
			rd = req.getRequestDispatcher("./uploadMaterial.jsp");
		} else if (linkName.equals("uploadQuestion")) {
			rd = req.getRequestDispatcher("./uploadQuestion.jsp");
		} else if (linkName.equals("viewAnswer")) {
			rd = req.getRequestDispatcher("./viewAnswer.jsp");
		}

		rd.forward(req, resp);

	}

}
