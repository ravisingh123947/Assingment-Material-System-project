package com.logitone.webapp.myproject.faculty.service;

import java.io.IOException;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator;

import javax.servlet.http.Part;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.logitone.webapp.myproject.faculty.dao.FacultyDao;
import com.logitone.webapp.myproject.faculty.dao.FacultyDaoImpl;
import com.logitone.webapp.myproject.faculty.entity.Faculty;
import com.logitone.webapp.myproject.faculty.entity.ViewAnswerOfStudent;
import com.logitone.webapp.myproject.student.entity.Student;

public class FacultyServiceImpl implements FacultyService {

	FacultyDao facultyDao = new FacultyDaoImpl();

	@Override
	public Faculty authenticateFacultyByEmailAndPassword(String username, String password) {
		return facultyDao.selectFacultyByEmailAndPassword(username, password);

	}

	@Override
	public boolean registerFaculty(Faculty faculy) {
		return facultyDao.insertFaculty(faculy);
	}

	@Override
	public Faculty[] getAllFacultiesInformation() {
		return facultyDao.getFaculties();
	}

	@Override
	public boolean deleteFacultyRecord(int id) {
		return facultyDao.deleteFaculty(id);
	}

	@Override
	public String getFileName(Part part) {
		String fileName = part.getSubmittedFileName();

		return fileName;
	}

	@Override
	public void saveFileName(String serverImagesDirectory, String fileName, Part part) {
		try {
			part.write(serverImagesDirectory + "\\" + fileName);
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
	}

	@Override
	public boolean uploadFile(int id, String fileName, String description) {

		return facultyDao.uploadMaterial(id, fileName, description);
	}

	@Override
	public boolean uploadQuestion(int id, String question) {
		return facultyDao.uploadQuestion(id, question);
	}

	@Override
	public void sendMail(String name, String email) {
		// MAIL SERVER INFORMATION
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// CONNECT TO MAIL SERVER
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("raviranjan8294053500@gmail.com", "hukeesreggmcbilu");
			}
		});

		// SEND EMAIL
		try {
			// COMPOSE EMAIL
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("raviranjan8294053500@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Uploaded Material");
			message.setText("Dear," + name + "\nI have uploaded your material.Please do visit your website");
			// SEND EMAIL
			Transport.send(message);

		} catch (MessagingException msgEx) {
			msgEx.printStackTrace();
		}
	}

	@Override
	public ViewAnswerOfStudent[] getAnswerOfStudents() {

		return facultyDao.getAnswerOfStudent();
	}

}
