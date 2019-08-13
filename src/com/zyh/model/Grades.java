package com.zyh.model;

public class Grades {
	private String courseName;
	private String grade;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Grades() {
		super();
	}
	public Grades(String courseName, String grade) {
		super();
		this.courseName = courseName;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Grades [courseName=" + courseName + ", grade=" + grade + "]";
	}
	
}
