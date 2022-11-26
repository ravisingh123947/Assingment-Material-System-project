package com.logitone.webapp.myproject.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logitone.webapp.myproject.faculty.dao.FacultyDaoImpl;
import com.logitone.webapp.myproject.faculty.entity.Faculty;
import com.logitone.webapp.myproject.student.entity.FacultyQuestion;
import com.logitone.webapp.myproject.student.service.StudentService;
import com.logitone.webapp.myproject.student.service.StudentServiceImpl;

public class ViewQuestion extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentService studentService = new StudentServiceImpl();

		FacultyQuestion[] question = studentService.getAllFacultyQuestion();

		if (question != null) {

			req.setAttribute("status", req.getAttribute("status"));
			req.setAttribute("QUESTIONLIST", question);

			RequestDispatcher rd = req.getRequestDispatcher("./viewQuestion.jsp");
			rd.forward(req, resp);
		}
	}

}
