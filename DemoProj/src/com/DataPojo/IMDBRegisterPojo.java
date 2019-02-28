package com.DataPojo;

public class IMDBRegisterPojo 
{
	String username;
	String password;
	String reenterpassword;
	public IMDBRegisterPojo(String username, String password, String reenterpassword) {
		super();
		this.username = username;
		this.password = password;
		this.reenterpassword = reenterpassword;
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
	public String getReenterpassword() {
		return reenterpassword;
	}
	public void setReenterpassword(String reenterpassword) {
		this.reenterpassword = reenterpassword;
	}
	

}
