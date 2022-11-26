package com.logitone.webapp.myproject.faculty.service;

import javax.servlet.http.Part;

import com.logitone.webapp.myproject.faculty.entity.Faculty;
import com.logitone.webapp.myproject.faculty.entity.ViewAnswerOfStudent;
import com.logitone.webapp.myproject.student.entity.Student;

public interface FacultyService {

	boolean registerFaculty(Faculty faculy);

	Faculty[] getAllFacultiesInformation();

	Faculty authenticateFacultyByEmailAndPassword(String username, String password);

	boolean deleteFacultyRecord(int id);

	String getFileName(Part part);

	void saveFileName(String serverImagesDirectory, String fileName, Part part);

	boolean uploadFile(int id, String fileName, String description);

	boolean uploadQuestion(int id, String question);

	void sendMail(String name, String email);

	ViewAnswerOfStudent[] getAnswerOfStudents();

}
