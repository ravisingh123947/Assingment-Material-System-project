package com.logitone.webapp.myproject.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLinkControllerServlet extends HttpServlet {

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
		} else if (linkName.equals("adminLogout")) {
			HttpSession session = req.getSession();
			session.removeAttribute("GETNAME");
			rd = req.getRequestDispatcher("./adminLogin.jsp");

		}
		rd.forward(req, resp);
	}
}
