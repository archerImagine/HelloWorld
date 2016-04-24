package com.cisco.cmad.model;

public class BlogUser {
	private String userName;
	private String email;
	private String password;
	private int userId;
	private Blog userBlog;
	
	public Blog getUserBlog() {
		return userBlog;
	}
	public void setUserBlog(Blog userBlog) {
		this.userBlog = userBlog;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
