package com.logitone.webapp.myproject.faculty.dao;

import com.logitone.webapp.myproject.faculty.entity.Faculty;
import com.logitone.webapp.myproject.faculty.entity.ViewAnswerOfStudent;
import com.logitone.webapp.myproject.student.entity.Student;

public interface FacultyDao {
	public Faculty selectFacultyByEmailAndPassword(String username, String password);

	public boolean insertFaculty(Faculty faculty);

	public Faculty[] getFaculties();

	public boolean deleteFaculty(int id);

	public boolean uploadMaterial(int id, String fileName, String description);

	public boolean uploadQuestion(int id, String question);

	public ViewAnswerOfStudent[] getAnswerOfStudent();

}
