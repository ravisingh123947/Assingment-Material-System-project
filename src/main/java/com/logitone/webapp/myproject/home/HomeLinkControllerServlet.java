package com.logitone.webapp.myproject.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeLinkControllerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		}

		rd.forward(req, resp);
	}

}
