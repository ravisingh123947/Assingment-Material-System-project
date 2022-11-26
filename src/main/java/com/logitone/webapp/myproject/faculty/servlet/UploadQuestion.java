package com.logitone.webapp.myproject.faculty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logitone.webapp.myproject.faculty.service.FacultyService;
import com.logitone.webapp.myproject.faculty.service.FacultyServiceImpl;
import com.logitone.webapp.myproject.student.entity.Student;

public class UploadQuestion extends HttpServlet {

	FacultyService facultyService = new FacultyServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String question = req.getParameter("question");
		HttpSession session = req.getSession();
		int id = (int) (session.getAttribute("FACULTYID"));

		boolean status = facultyService.uploadQuestion(id, question);
		if (status) {

			req.setAttribute("QUESTIONUPLOADED", "success");
		} else {
			req.setAttribute("QUESTIONUPLOADED", "failure");
		}

		RequestDispatcher rd = req.getRequestDispatcher("./uploadQuestion.jsp");
		rd.forward(req, resp);

	}

}
