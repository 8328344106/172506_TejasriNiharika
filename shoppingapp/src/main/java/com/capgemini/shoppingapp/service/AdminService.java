package com.capgemini.shoppingapp.service;

import java.io.IOException;
import java.util.List;
import com.capgemini.shoppingapp.model.Cart;
import com.capgemini.shoppingapp.model.Customer;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.model.Products;


public interface AdminService {
	

	public Products addProductdetails(Products product) throws IOException;
	
	public Customer addadmin(Customer cus);

	public String removeproduct(String id);
	
	public List<Customer> viewAllCustomers();
	
	public String removecustomer(String id);

	public List<CustomerOrders> viewallOrders();
	
	public List<Cart> viewallCarts();
	
	public Customer addsalesperson(Customer cus);
	
}
