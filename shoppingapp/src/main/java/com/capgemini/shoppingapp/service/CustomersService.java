package com.capgemini.shoppingapp.service;

import java.util.List;

import com.capgemini.shoppingapp.model.Cart;
import com.capgemini.shoppingapp.model.Customer;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.model.Products;

public interface CustomersService {
	
	public List<Products> viewAllProducts();
	
	public Products getProductsById(String id);

	public Customer addcustomer(Customer cus);

	public Customer getCustomerById(String id);

	public Customer updatecustomer(Customer cus);
	
	public Cart addproducttocart(String email,Products product);
	
	public Cart getCartByEmail(String email);
	
	public CustomerOrders buyall(String email,CustomerOrders orders);
	
	public CustomerOrders buynow(String email,Products product,CustomerOrders orders);
	
	public List<CustomerOrders> getordersbuymail(String email);
	
	public String cancelorder(String id);
}
