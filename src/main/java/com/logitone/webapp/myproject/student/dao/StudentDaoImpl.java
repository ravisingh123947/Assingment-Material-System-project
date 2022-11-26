package com.logitone.webapp.myproject.student.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Scrollable;

import com.logitone.webapp.myproject.dao.DatabaseDataSource;
import com.logitone.webapp.myproject.student.entity.FacultyMaterial;
import com.logitone.webapp.myproject.student.entity.FacultyQuestion;
import com.logitone.webapp.myproject.student.entity.Student;

public class StudentDaoImpl extends DatabaseDataSource implements StudentDao {

	@Override
	public Student selectStudentByEmailAndPassword(String username, String password) {
		Student student = null;

		Connection dbCon = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT * FROM student WHERE student_username= '" + username + "' " + " and "
					+ "student_password='" + password + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				student = new Student();
				student.setId(1);
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setUsername(rs.getString(4));
				student.setPassword(rs.getString(5));

			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
			closeDbConection(dbCon);
		}
		return student;
	}

	@Override
	public boolean insertStudent(Student student) {
		boolean status = false;

		Connection dbCon = null;
		Statement stmt = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement();

			String sql = "INSERT INTO student VALUES ('" + student.getId() + "', '" + student.getName() + "', '"
					+ student.getEmail() + "', '" + student.getUsername() + "', '" + student.getPassword() + "')";

			int row = stmt.executeUpdate(sql);
			if (row != 0) {
				status = true;
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			closeStatement(stmt);
			closeDbConection(dbCon);
		}
		return status;
	}

	@Override
	public Student[] getStudents() {
		Connection dbCon = null;
		Statement stmt = null;
		ResultSet result = null;
		Student[] students = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT * FROM student";

			result = stmt.executeQuery(sql);
			int size = 0;
			while (result.next()) {
				size++;
			}
			result = stmt.executeQuery(sql);
			students = new Student[size];
			int count = 0;
			result.beforeFirst();
			while (result.next()) {
				Student student = new Student();
				student.setId(result.getInt(1));
				student.setName(result.getString(2));
				student.setEmail(result.getString(3));
				student.setUsername(result.getString(4));
				student.setPassword(result.getString(5));
				students[count] = student;
				count++;

//				employeelist[count] = new EmployeeList(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
//				count++;

			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			closeResultSet(result);
			closeStatement(stmt);
			closeDbConection(dbCon);
		}
		return students;

	}

	@Override
	public boolean deleteStudentRecord(int id) {
		boolean status = false;

		Connection dbCon = null;
		Statement stmt = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement();

			String sql = "DELETE FROM student WHERE  student_id=" + id;

			int row = stmt.executeUpdate(sql);
			if (row != 0) {
				status = true;
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			closeStatement(stmt);
			closeDbConection(dbCon);
		}
		return status;
	}

	@Override
	public FacultyQuestion[] getFacultyQuestion() {

		Connection dbCon = null;
		Statement stmt = null;
		ResultSet result = null;
		FacultyQuestion[] facultyQuestion = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT * FROM faculty_question";

			result = stmt.executeQuery(sql);
			int size = 0;
			while (result.next()) {
				size++;
			}
			result = stmt.executeQuery(sql);
			facultyQuestion = new FacultyQuestion[size];
			int count = 0;
			result.beforeFirst();
			while (result.next()) {
				FacultyQuestion question = new FacultyQuestion();
				question.setFaculty_id(result.getInt(1));
				question.setFaculty_question(result.getString(2));
				question.setQuestion_id(result.getInt(3));
				facultyQuestion[count] = question;
				count++;

//				employeelist[count] = new EmployeeList(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
//				count++;

			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			closeResultSet(result);
			closeStatement(stmt);
			closeDbConection(dbCon);
		}
		return facultyQuestion;

	}

	@Override
	public boolean answerResponseTable(int question_id, String student_name, String answer) {
		boolean status = false;

		Connection dbCon = null;
		Statement stmt = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement();

			String sql = "INSERT INTO answer_response VALUES ('" + question_id + "', '" + student_name + "', '" + answer
					+ "')";

			int row = stmt.executeUpdate(sql);
			if (row != 0) {
				status = true;
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			closeStatement(stmt);
			closeDbConection(dbCon);
		}
		return status;
	}
	
	
	@Override
	public FacultyMaterial[] getFacultyMaterial() {
		
		Connection dbCon = null;
		Statement stmt = null;
		ResultSet result = null;
		FacultyMaterial[] facultyMaterial = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT * FROM faculty_material";

			result = stmt.executeQuery(sql);
			int size = 0;
			while (result.next()) {
				size++;
			}
			result = stmt.executeQuery(sql);
			facultyMaterial = new FacultyMaterial[size];
			int count = 0;
			result.beforeFirst();
			while (result.next()) {
				FacultyMaterial material = new FacultyMaterial();
				material.setFaculty_id(result.getInt(1));
				material.setMaterial_name(result.getString(2));;
				material.setDescription(result.getString(3));
				facultyMaterial[count] = material;
				count++;

//				employeelist[count] = new EmployeeList(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
//				count++;

			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			closeResultSet(result);
			closeStatement(stmt);
			closeDbConection(dbCon);
		}
		return facultyMaterial;
	}

}
