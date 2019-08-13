package com.zyh.model;

public class Student extends User{
	private int id;
	private String name;
	private String account;
	private String password;
	private String sclass;
	private String avatar;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Student() {
		super();
	}
	public Student(int id, String name, String account, String password, String sclass) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.sclass = sclass;
	}
	
	public Student(String name, String account, String sclass, String avatar) {
		super();
		this.name = name;
		this.account = account;
		this.sclass = sclass;
		this.avatar = avatar;
	}
	
	public Student(int id, String name, String account, String password, String sclass, String avatar) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.sclass = sclass;
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password + ", sclass="
				+ sclass + ", avatar=" + avatar + "]";
	}
	
}
