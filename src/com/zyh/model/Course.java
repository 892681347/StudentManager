package com.zyh.model;

public class Course {
	private int day;
	private int time;
	private String subject;
	private String color;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Course() {
		super();
	}
	public Course(int day, int time, String subject, String color) {
		super();
		this.day = day;
		this.time = time;
		this.subject = subject;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Course [day=" + day + ", time=" + time + ", subject=" + subject + ", color=" + color + "]";
	}
	
}
