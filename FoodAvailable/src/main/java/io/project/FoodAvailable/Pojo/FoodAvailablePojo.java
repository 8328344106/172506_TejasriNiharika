package io.project.FoodAvailable.Pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FoodAvailablePojo {
	
	@Id
	String id;
	String username;
	String password;
	String imageUrl;
	String price;
	String service;
	String description;
	
	
	public FoodAvailablePojo(String id, String username, String password, String imageUrl, String price, String service,
			String description) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.imageUrl = imageUrl;
		this.price = price;
		this.service = service;
		this.description = description;
	
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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

	@Override
	public String toString() {
		return "FoodAvailablePojo [username=" + username + ", password=" + password + ", imageUrl=" + imageUrl
				+ ", price=" + price + ", service=" + service + ", description=" + description + "]";
	}
	

}
