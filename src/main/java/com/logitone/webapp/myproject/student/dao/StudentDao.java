package com.logitone.webapp.myproject.student.dao;

import com.logitone.webapp.myproject.student.entity.FacultyMaterial;
import com.logitone.webapp.myproject.student.entity.FacultyQuestion;
import com.logitone.webapp.myproject.student.entity.Student;

public interface StudentDao {
	public Student selectStudentByEmailAndPassword(String username, String password);

	public boolean insertStudent(Student student);

	public Student[] getStudents();

	boolean deleteStudentRecord(int id);

	public FacultyQuestion[] getFacultyQuestion();

	public boolean answerResponseTable(int question_id, String student_name, String answer);
	
	public FacultyMaterial[] getFacultyMaterial();
}
