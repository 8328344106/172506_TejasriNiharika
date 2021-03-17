package com.capgemini.shoppingapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer 
{
	
	@Id
	private String id;

	private String name;
	
	private String password;
	
	private String email;
	
	private String phoneNumber;
	
	private String role;

	public Customer(String name, String password, String email, String phoneNumber) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Customer(String name, String password, String email, String phoneNumber, String role) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}
	
	
	
	
	

}
