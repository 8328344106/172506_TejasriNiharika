package io.project.UserCredentials.Userpojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Userpojo 
{
	@Id
	String username;
	String email;
	String mobilenumber;
	String password;
	String repeatpassword;
	
	public Userpojo(String username, String email, String mobilenumber, String password, String repeatpassword) {
		super();
		this.username = username;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.password = password;
		this.repeatpassword = repeatpassword;
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatpassword() {
		return repeatpassword;
	}
	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}
	
	

}
