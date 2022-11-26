package com.logitone.webapp.myproject.faculty.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.logitone.webapp.myproject.faculty.entity.Faculty;
import com.logitone.webapp.myproject.faculty.service.FacultyService;
import com.logitone.webapp.myproject.faculty.service.FacultyServiceImpl;
import com.logitone.webapp.myproject.student.entity.Student;
import com.logitone.webapp.myproject.student.service.StudentService;
import com.logitone.webapp.myproject.student.service.StudentServiceImpl;

@MultipartConfig
public class UploadMaterial extends HttpServlet {

	FacultyService facultyService = new FacultyServiceImpl();

	StudentService studentServie = new StudentServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
		Student[] student = studentServie.getAllStudents();
		Part filePart = req.getPart("material");
		String description = req.getParameter("description");
		HttpSession session = req.getSession();
		int id = (int) (session.getAttribute("FACULTYID"));
//		out.println("<p>"+id+"</p>");
		String fileName = facultyService.getFileName(filePart);
		boolean status = facultyService.uploadFile(id, fileName, description);
		if (status) {
			String serverImagesDirectory = getServletContext().getRealPath("/") + "images";

			facultyService.saveFileName(serverImagesDirectory, fileName, filePart);

			req.setAttribute("FILEUPLOADED", "success");
		} else {
			req.setAttribute("FILEUPLOADED", "failure");
		}
		for (Student stu : student) {
			facultyService.sendMail(stu.getName(), stu.getEmail());
		}

		RequestDispatcher rd = req.getRequestDispatcher("./uploadMaterial.jsp");
		rd.forward(req, resp);

	}

}
