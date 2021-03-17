package com.capgemini.shoppingapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	private String id;
	
	private String producttype;
	
	private String productname;
	
	private String productid;
	
	private String price;
	
	public ProductDTO(String producttype, String productname, String productid, String price) {
		super();
		this.producttype = producttype;
		this.productname = productname;
		this.productid = productid;
		this.price = price;
	}
	
	
	
	

}
