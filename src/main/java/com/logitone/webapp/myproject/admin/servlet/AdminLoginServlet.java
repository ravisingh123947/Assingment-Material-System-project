package com.logitone.webapp.myproject.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logitone.webapp.myproject.admin.dao.AdminDao;

public class AdminLoginServlet extends HttpServlet {
	AdminDao adminDao = new AdminDao();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		String name = adminDao.selectEmployeeByEmailAndPassword(username, password);
		if (name != null) {
			req.setAttribute("NAME", name);

			RequestDispatcher rd = req.getRequestDispatcher("./adminAfterSignedIn.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("./adminLogin.jsp");
			rd.forward(req, resp);
		}
	}

}
