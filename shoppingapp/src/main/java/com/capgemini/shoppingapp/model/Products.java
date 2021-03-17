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
public class Products 
{
	@Id
	private String id;
	
	private String producttype;
	
	private String productname;
	
	private String productid;
	
	private String price;
	
	

	public Products(String producttype, String productname, String productid, String price) {
		super();
		this.producttype = producttype;
		this.productname = productname;
		this.productid = productid;
		this.price = price;
	}





	@Override
	public String toString() {
		return "Products [id=" + id + ", producttype=" + producttype + ", productname=" + productname + ", productid="
				+ productid + ", price=" + price + "]";
	}

	
	
		

}
