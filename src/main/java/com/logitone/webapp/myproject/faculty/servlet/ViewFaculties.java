package com.logitone.webapp.myproject.faculty.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logitone.webapp.myproject.faculty.dao.FacultyDaoImpl;
import com.logitone.webapp.myproject.faculty.entity.Faculty;
import com.logitone.webapp.myproject.faculty.service.FacultyService;
import com.logitone.webapp.myproject.faculty.service.FacultyServiceImpl;

public class ViewFaculties extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FacultyService faculty = new FacultyServiceImpl();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		Faculty[] faculties = faculty.getAllFacultiesInformation();

		if (faculties != null) {

			req.setAttribute("status", req.getAttribute("status"));
			req.setAttribute("FACULTYLIST", faculties);
//    		out.println("<p>"+faculties[0].getEmail()+"</p>");

			RequestDispatcher rd = req.getRequestDispatcher("./viewFaculty.jsp");
			rd.forward(req, resp);
		}
	}

}
