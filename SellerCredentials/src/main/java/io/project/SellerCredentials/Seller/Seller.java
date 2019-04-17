package io.project.SellerCredentials.Seller;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Seller {

	String username;
	String password;
	String imageUrl;
	String price;
	String service;
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Seller(String username, String password, String imageUrl, String price, String service) {
		super();
		this.username = username;
		this.password = password;
		this.imageUrl = imageUrl;
		this.price = price;
		this.service = service;
	}
	
	
}
