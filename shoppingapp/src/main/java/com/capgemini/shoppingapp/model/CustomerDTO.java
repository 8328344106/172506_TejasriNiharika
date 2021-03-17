package com.capgemini.shoppingapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO 
{
	private String id;

	private String name;
	
	private String password;
	
	private String email;
	
	private String phoneNumber;
	
	private String role;

	public CustomerDTO(String name, String password, String email, String phoneNumber) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	
	
	

}
