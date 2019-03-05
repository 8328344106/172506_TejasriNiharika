package com.Customer;

import com.Address.Address;

public class Customer 
{
	String customerId;
	String customerName;
	long customerContact;
	Address customerAddress;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(long customerContact) {
		this.customerContact = customerContact;
	}
	public Address getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
	public void getCustomer()
	{
		System.out.println("Customer Id: "+getCustomerId());
		System.out.println("Customer Name: "+getCustomerName());
		System.out.println("Customer Contact: "+getCustomerContact());
		System.out.println("Customer Address: "+getCustomerAddress().getStreet()+getCustomerAddress().getCity()+getCustomerAddress().getState()
				+getCustomerAddress().getZip()+getCustomerAddress().getCountry());
		
	}
	

}
