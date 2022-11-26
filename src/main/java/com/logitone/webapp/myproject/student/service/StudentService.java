package com.logitone.webapp.myproject.student.service;

import com.logitone.webapp.myproject.student.entity.FacultyMaterial;
import com.logitone.webapp.myproject.student.entity.FacultyQuestion;
import com.logitone.webapp.myproject.student.entity.Student;

public interface StudentService {

	Student authenticateStudentByUsernameAndPassword(String username, String password);

	boolean registerStudent(Student student);

	Student[] getAllStudents();

	boolean deleteStudentRecord(int id);

	FacultyQuestion[] getAllFacultyQuestion();

	boolean answerResponse(int question_id, String student_name, String answer);
	
	FacultyMaterial[] getAllMaterial();

}
