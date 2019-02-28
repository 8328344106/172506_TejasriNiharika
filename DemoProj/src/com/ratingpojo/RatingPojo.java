package com.ratingpojo;

public class RatingPojo 
{
	String username;
	String password;
	String rating;
	String coment;
	public RatingPojo(String username, String password, String rating, String coment) {
		super();
		this.username = username;
		this.password = password;
		this.rating = rating;
		this.coment = coment;
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	
}
