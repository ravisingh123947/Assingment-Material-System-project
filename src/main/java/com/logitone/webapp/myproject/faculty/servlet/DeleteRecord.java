package com.logitone.webapp.myproject.faculty.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logitone.webapp.myproject.faculty.service.FacultyService;
import com.logitone.webapp.myproject.faculty.service.FacultyServiceImpl;

public class DeleteRecord extends HttpServlet {

	FacultyService facultyServiceImpl = new FacultyServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		boolean status = facultyServiceImpl.deleteFacultyRecord(id);

		if (status) {
			req.setAttribute("status", "Deleted successfully!!");
			RequestDispatcher rd = req.getRequestDispatcher("./viewfaculty");
			rd.forward(req, resp);
		} else {
			req.setAttribute("status", "Deletion failed!!");
			RequestDispatcher rd = req.getRequestDispatcher("./viewfaculty");
			rd.forward(req, resp);
		}

	}

}
