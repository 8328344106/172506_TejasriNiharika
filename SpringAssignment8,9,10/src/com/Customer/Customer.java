package com.Customer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.Address.Address;

public class Customer implements InitializingBean,DisposableBean,ApplicationContextAware{
    private int customerId;
	private String customerName;
	 private int customerContact;
	 private Address customerAddress;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(int customerContact) {
		this.customerContact = customerContact;
	}
	public Address getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	 public Customer(int customerId, String customerName, int customerContact, Address customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
	}
	public void getCustomer()
	 {
		 System.out.println("CustomerId is:"+getCustomerId());
		 System.out.println("CustomerName is:"+getCustomerName());
		 System.out.println("CustomerContact is:"+getCustomerContact());
		 System.out.println("Customer Address is:"+getCustomerAddress().getStreet()+"  "+getCustomerAddress().getCity()+" "+getCustomerAddress().getZip()+" "+getCustomerAddress().getState()+" "+getCustomerAddress().getCountry());
	 }
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Destroyed Customer");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hi customer");
	}
		public void myInit()
		{
			System.out.println("MyInit() called...");
		}
		public void myCleanUp() {
			System.out.println("Cleaned...");
		}
		@Override
		public void setApplicationContext(ApplicationContext context) throws BeansException {
			System.out.println("ApplicationContextAware invoked....");
			System.out.println(context);
		}
}