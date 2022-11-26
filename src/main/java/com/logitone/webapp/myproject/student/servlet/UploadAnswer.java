package com.logitone.webapp.myproject.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logitone.webapp.myproject.student.service.StudentService;
import com.logitone.webapp.myproject.student.service.StudentServiceImpl;

public class UploadAnswer extends HttpServlet {

	StudentService studentService = new StudentServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int question_id = Integer.parseInt(req.getParameter("question_id"));
		String answer = req.getParameter("answer");
		HttpSession session = req.getSession();
		String student_name = (String) (session.getAttribute("STUDENTNAME"));

		boolean status = studentService.answerResponse(question_id, student_name, answer);

		if (status) {

			req.setAttribute("ANSWERUPLOADED", "success");
		} else {
			req.setAttribute("ANSWERUPLOADED", "failure");
		}

		RequestDispatcher rd = req.getRequestDispatcher("./viewQuestion");
		rd.forward(req, resp);

	}

}
