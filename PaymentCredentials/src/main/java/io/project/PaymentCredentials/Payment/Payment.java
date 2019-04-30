package io.project.PaymentCredentials.Payment;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payment {
	
	String username;
	String password;
	String address;
	String cardnumber;
	String expdate;
	String cvv;
	String cardname;
	String imageUrl;
	String price;
	
	public Payment(String username, String password, String address, String cardnumber, String expdate, String cvv,
			String cardname, String imageUrl, String price) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.cardnumber = cardnumber;
		this.expdate = expdate;
		this.cvv = cvv;
		this.cardname = cardname;
		this.imageUrl = imageUrl;
		this.price = price;
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
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
