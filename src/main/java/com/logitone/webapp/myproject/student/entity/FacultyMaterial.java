package com.logitone.webapp.myproject.student.entity;

public class FacultyMaterial {

	private int faculty_id;
	private String material_name;
	private String description;
	public FacultyMaterial(int faculty_id, String material_name, String description) {
		super();
		this.faculty_id = faculty_id;
		this.material_name = material_name;
		this.description = description;
	}
	public FacultyMaterial() {
		super();
	}
	public int getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "FacultyMaterial [faculty_id=" + faculty_id + ", material_name=" + material_name + ", description="
				+ description + "]";
	}
	
	

}
