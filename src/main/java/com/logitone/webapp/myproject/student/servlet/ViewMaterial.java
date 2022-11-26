package com.logitone.webapp.myproject.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logitone.webapp.myproject.student.entity.FacultyMaterial;
import com.logitone.webapp.myproject.student.entity.FacultyQuestion;
import com.logitone.webapp.myproject.student.service.StudentService;
import com.logitone.webapp.myproject.student.service.StudentServiceImpl;

public class ViewMaterial extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentService studentService = new StudentServiceImpl();
		
		FacultyMaterial[] material = studentService.getAllMaterial();
		
		if(material != null) {
			req.setAttribute("MATERIALLIST", material);
			
			RequestDispatcher rd = req.getRequestDispatcher("./viewMaterial.jsp");
			rd.forward(req, resp);
			
		}
	}

}
