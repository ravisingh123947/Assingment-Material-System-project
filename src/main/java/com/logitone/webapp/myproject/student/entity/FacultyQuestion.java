package com.logitone.webapp.myproject.student.entity;

public class FacultyQuestion {

	private int faculty_id;
	private String faculty_question;
	private int question_id;

	public FacultyQuestion(int faculty_id, String faculty_question, int question_id) {
		super();
		this.faculty_id = faculty_id;
		this.faculty_question = faculty_question;
		this.question_id = question_id;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public FacultyQuestion(int faculty_id, String faculty_question) {
		this.faculty_id = faculty_id;
		this.faculty_question = faculty_question;
	}

	public FacultyQuestion() {

	}

	public int getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getFaculty_question() {
		return faculty_question;
	}

	public void setFaculty_question(String faculty_question) {
		this.faculty_question = faculty_question;
	}

	@Override
	public String toString() {
		return "FacultyQuestion [faculty_id=" + faculty_id + ", faculty_question=" + faculty_question + ", question_id="
				+ question_id + "]";
	}

}
