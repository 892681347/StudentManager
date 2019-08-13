package com.zyh.model;

public class Teacher extends User{
	private int id;
	private String name;
	private String account;
	private String password;
	private String tclass;
	private String avatar;
	private int getId() {
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
	public String getTclass() {
		return tclass;
	}
	public void setTclass(String tclass) {
		this.tclass = tclass;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Teacher() {
		super();
	}
	
	public Teacher(String name, String account, String tclass, String avatar) {
		super();
		this.name = name;
		this.account = account;
		this.tclass = tclass;
		this.avatar = avatar;
	}
	public Teacher(int id, String name, String account, String password, String tclass) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.tclass = tclass;
	}
	
	public Teacher(int id, String name, String account, String password, String tclass, String avatar) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.tclass = tclass;
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password + ", tclass="
				+ tclass + ", avatar=" + avatar + "]";
	}
	
}
