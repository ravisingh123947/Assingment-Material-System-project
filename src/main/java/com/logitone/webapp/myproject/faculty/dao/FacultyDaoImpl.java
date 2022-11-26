package com.logitone.webapp.myproject.faculty.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Scrollable;

import com.logitone.webapp.myproject.dao.DatabaseDataSource;
import com.logitone.webapp.myproject.faculty.entity.Faculty;
import com.logitone.webapp.myproject.faculty.entity.ViewAnswerOfStudent;
import com.logitone.webapp.myproject.student.entity.Student;

public class FacultyDaoImpl extends DatabaseDataSource implements FacultyDao {

	@Override
	public Faculty selectFacultyByEmailAndPassword(String username, String password) {
		Faculty faculty =null;

		Connection dbCon = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT * FROM faculty WHERE faculty_username= '" + username + "' " + " and "
					+ "faculty_password='" + password + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				faculty = new Faculty();
				faculty.setId(1);
				faculty.setName(rs.getString(2));
				faculty.setEmail(rs.getString(3));
				faculty.setUsername(rs.getString(4));
				faculty.setPassword(rs.getString(5));

			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
			closeDbConection(dbCon);
		}
		return faculty;
	}

	@Override
	public boolean insertFaculty(Faculty faculty) {
		boolean status = false;

		Connection dbCon = null;
		Statement stmt = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement();

			String sql = "INSERT INTO faculty VALUES ('" + faculty.getId() + "', '" + faculty.getName() + "', '"
					+ faculty.getEmail() + "', '" + faculty.getUsername() + "', '" + faculty.getPassword() + "')";

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
	public Faculty[] getFaculties() {
		Connection dbCon = null;
		Statement stmt = null;
		ResultSet result = null;
		Faculty[] faculties = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT * FROM faculty";

			result = stmt.executeQuery(sql);
			int size = 0;
			while (result.next()) {
				size++;
			}
			result = stmt.executeQuery(sql);
			faculties = new Faculty[size];
			int count = 0;
			result.beforeFirst();
			while (result.next()) {
				Faculty faculty = new Faculty();
				faculty.setId(result.getInt(1));
				faculty.setName(result.getString(2));
				faculty.setEmail(result.getString(3));
				faculty.setUsername(result.getString(4));
				faculty.setPassword(result.getString(5));
				faculties[count] = faculty;
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
		return faculties;

	}

	@Override
	public boolean deleteFaculty(int id) {
		boolean status = false;

		Connection dbCon = null;
		Statement stmt = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement();

			String sql = "DELETE FROM FACULTY WHERE faculty_id=" + id;

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
	public boolean uploadMaterial(int id, String fileName, String description) {
		boolean status = false;

		Connection dbCon = null;
		Statement stmt = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement();

			String sql = "INSERT INTO faculty_material VALUES ('" + id + "', '" + fileName + "', '" + description
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
	public boolean uploadQuestion(int id, String question) {
		boolean status = false;

		Connection dbCon = null;
		Statement stmt = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement();

			String sql = "INSERT INTO faculty_question(faculty_id,faculty_question) VALUES ('" + id + "', '" + question
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
	public ViewAnswerOfStudent[] getAnswerOfStudent() {
		Connection dbCon = null;
		Statement stmt = null;
		ResultSet result = null;
		ViewAnswerOfStudent[] answerOfStudent = null;

		try {
			dbCon = getDbConnection();
			stmt = dbCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "select answer_response.student_name,faculty_question.faculty_question,answer_response.answer  from faculty_question  inner join answer_response  on faculty_question.question_id=answer_response.question_id;";

			result = stmt.executeQuery(sql);
			int size = 0;
			while (result.next()) {
				size++;
			}
			result = stmt.executeQuery(sql);
			answerOfStudent = new ViewAnswerOfStudent[size];
			int count = 0;
			result.beforeFirst();
			while (result.next()) {
				ViewAnswerOfStudent answer = new ViewAnswerOfStudent();
				answer.setStudent_name(result.getString(1));
				answer.setFaculty_question(result.getString(2));
				answer.setAnswer(result.getString(3));
				answerOfStudent[count] = answer;
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
		return answerOfStudent;
	}

}
