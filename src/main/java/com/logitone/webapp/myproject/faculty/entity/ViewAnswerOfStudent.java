package com.logitone.webapp.myproject.faculty.entity;

public class ViewAnswerOfStudent {

	private String student_name;
	private String faculty_question;
	private String answer;

	public ViewAnswerOfStudent(String student_name, String faculty_question, String answer) {
		super();
		this.student_name = student_name;
		this.faculty_question = faculty_question;
		this.answer = answer;
	}

	public ViewAnswerOfStudent() {
		super();
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getFaculty_question() {
		return faculty_question;
	}

	public void setFaculty_question(String faculty_question) {
		this.faculty_question = faculty_question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "ViewAnswerOfStudent [student_name=" + student_name + ", faculty_question=" + faculty_question
				+ ", answer=" + answer + "]";
	}

}
