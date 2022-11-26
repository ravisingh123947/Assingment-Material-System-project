package com.logitone.webapp.myproject.faculty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logitone.webapp.myproject.faculty.entity.ViewAnswerOfStudent;
import com.logitone.webapp.myproject.faculty.service.FacultyService;
import com.logitone.webapp.myproject.faculty.service.FacultyServiceImpl;

public class ViewAnswer extends HttpServlet {

	FacultyService facultyService = new FacultyServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ViewAnswerOfStudent[] viewAnsOfStudent = facultyService.getAnswerOfStudents();

		if (viewAnsOfStudent != null) {

			req.setAttribute("ANSWER", viewAnsOfStudent);

			RequestDispatcher rd = req.getRequestDispatcher("./viewAnswer.jsp");
			rd.forward(req, resp);
		}

	}

}
