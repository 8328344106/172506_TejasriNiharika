package io.project.PaymentCredentials.Payment;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payment {
	
	String address;
	String cardnumber;
	String expdate;
	String cvv;
	String cardname;
	
	public Payment(String address, String cardnumber, String expdate, String cvv, String cardname) {
		super();
		this.address = address;
		this.cardnumber = cardnumber;
		this.expdate = expdate;
		this.cvv = cvv;
		this.cardname = cardname;
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
