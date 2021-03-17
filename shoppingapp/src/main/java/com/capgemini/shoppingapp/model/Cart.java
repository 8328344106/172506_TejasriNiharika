package com.capgemini.shoppingapp.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart 
{
	@Id
	private String id;
	
	private String email;
	
	private List<Products> cartitems=new ArrayList<>();

	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", email=" + email + ", cartitems=" + cartitems + "]";
	}


	public Cart(String email, List<Products> cartitems) {
		super();
		this.email = email;
		this.cartitems = cartitems;
	}
	
	
	
}
