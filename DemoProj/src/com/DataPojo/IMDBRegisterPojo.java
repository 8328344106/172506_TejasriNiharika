package com.DataPojo;

public class IMDBRegisterPojo 
{
	String firstname;
	String lastname;
	String phonenumber;
	String mailid;
	String password;
	String reenterpassword;
	public IMDBRegisterPojo(String firstname, String lastname, String phonenumber2, String mailid, String password,
			String reenterpassword) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber2;
		this.mailid = mailid;
		this.password = password;
		this.reenterpassword = reenterpassword;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
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
