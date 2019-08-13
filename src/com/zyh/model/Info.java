package com.zyh.model;

public class Info {
	private String sex;
	private String bloodType;
	private String age;
	private String site;
	private String qq;
	private String constellation;
	private String interest;
	
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public Info() {
		super();
	}
	public Info(String sex, String bloodType, String age, String site,String qq, String constellation, String interest) {
		super();
		this.sex = sex;
		this.bloodType = bloodType;
		this.age = age;
		this.site = site;
		this.qq = qq;
		this.constellation = constellation;
		this.interest = interest;
	}
	@Override
	public String toString() {
		return "Info [sex=" + sex + ", bloodType=" + bloodType + ", age=" + age + ", site=" + site + ", qq=" + qq
				+ ", constellation=" + constellation + ", interest=" + interest + "]";
	}
	
	
	
}
