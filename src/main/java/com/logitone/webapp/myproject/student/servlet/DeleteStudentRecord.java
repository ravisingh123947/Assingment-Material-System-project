package com.logitone.webapp.myproject.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logitone.webapp.myproject.student.service.StudentService;
import com.logitone.webapp.myproject.student.service.StudentServiceImpl;

public class DeleteStudentRecord extends HttpServlet {
	StudentService studentService = new StudentServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));

		boolean status = studentService.deleteStudentRecord(id);

		if (status) {
			req.setAttribute("status", "Deleted successfully!!");
			RequestDispatcher rd = req.getRequestDispatcher("./viewstudent");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("./viewstudent");
			rd.forward(req, resp);
		}

	}

}
