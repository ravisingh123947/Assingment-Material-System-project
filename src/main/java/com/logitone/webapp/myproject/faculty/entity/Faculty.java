package com.logitone.webapp.myproject.faculty.entity;

public class Faculty {

	private int id;
	private String name;
	private String email;
	private String username;
	private String password;

	public Faculty() {

	}

	public Faculty(int id, String name, String email, String username, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Faculty [name=" + name + ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}

}
