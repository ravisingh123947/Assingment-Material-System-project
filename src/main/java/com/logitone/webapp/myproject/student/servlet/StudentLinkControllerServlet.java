package com.logitone.webapp.myproject.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StudentLinkControllerServlet extends HttpServlet {

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
		} else if (linkName.equals("studentLogOut")) {
			HttpSession session = req.getSession();
			session.removeAttribute("STUDENTNAME");
			session.removeAttribute("STUDENTID");
			rd = req.getRequestDispatcher("./studentLogin.jsp");
		} else if (linkName.equals("viewQuestion")) {
			rd = req.getRequestDispatcher("./ViewQuestion");
		} else if (linkName.equals("viewMaterial")) {
			rd = req.getRequestDispatcher("./viewMaterial.jsp");
		}
		rd.forward(req, resp);
	}
}
