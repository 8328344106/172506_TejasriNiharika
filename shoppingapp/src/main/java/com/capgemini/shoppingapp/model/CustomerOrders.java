package com.capgemini.shoppingapp.model;

import java.math.BigInteger;
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
public class CustomerOrders 
{
	@Id
	private String id;
	
	private String email;
	
	private List<Products> orderditems=new ArrayList<>();
	
	private BigInteger cardnumber;
	
	private int cvv;
	
	private int expmon;
	
	private int expyear;
	
	private String status;

	public CustomerOrders(BigInteger cardnumber, int cvv, int expmon, int expyear, String status) {
		super();
		this.cardnumber = cardnumber;
		this.cvv = cvv;
		this.expmon = expmon;
		this.expyear = expyear;
		this.status = status;
	}

	public CustomerOrders(String email, List<Products> orderditems, int cvv, int expmon,
			int expyear, String status) 
	{
		super();
		this.email = email;
		this.orderditems = orderditems;
		this.cvv = cvv;
		this.expmon = expmon;
		this.expyear = expyear;
		this.status = status;
	}
		
}
