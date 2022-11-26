package com.logitone.webapp.myproject.student.service;

import com.logitone.webapp.myproject.student.dao.StudentDao;
import com.logitone.webapp.myproject.student.dao.StudentDaoImpl;
import com.logitone.webapp.myproject.student.entity.FacultyMaterial;
import com.logitone.webapp.myproject.student.entity.FacultyQuestion;
import com.logitone.webapp.myproject.student.entity.Student;

public class StudentServiceImpl implements StudentService {

	StudentDao studentDao = new StudentDaoImpl();

	@Override
	public Student authenticateStudentByUsernameAndPassword(String username, String password) {
		return studentDao.selectStudentByEmailAndPassword(username, password);

	}

	@Override
	public boolean registerStudent(Student student) {
		return studentDao.insertStudent(student);
	}

	@Override
	public Student[] getAllStudents() {
		return studentDao.getStudents();
	}

	@Override
	public boolean deleteStudentRecord(int id) {

		return studentDao.deleteStudentRecord(id);
	}

	@Override
	public FacultyQuestion[] getAllFacultyQuestion() {

		return studentDao.getFacultyQuestion();
	}

	@Override
	public boolean answerResponse(int question_id, String student_name, String answer) {

		return studentDao.answerResponseTable(question_id, student_name, answer);
	}
    

	@Override
	public FacultyMaterial[] getAllMaterial() {
		
		return studentDao.getFacultyMaterial();
	}
}
