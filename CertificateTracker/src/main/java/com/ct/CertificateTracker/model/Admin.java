package com.ct.CertificateTracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Admin")
public class Admin {
	@Id
	private Integer empId;
	private String password;
	private String name;
	
	
	
	
	@Override
	public String toString() {
		return "Admin [empId=" + empId + ", password=" + password + ", name=" + name + "]";
	}
	public Admin(Integer empId, String password, String name) {
		super();
		this.empId = empId;
		this.password = password;
		this.name = name;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
