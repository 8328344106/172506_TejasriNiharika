package com.capgemini.shoppingapp.serviceimplementation;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.capgemini.shoppingapp.model.Cart;
import com.capgemini.shoppingapp.model.Customer;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.model.Products;
import com.capgemini.shoppingapp.repository.CartRepository;
import com.capgemini.shoppingapp.repository.CustomerOrdersRepository;
import com.capgemini.shoppingapp.repository.CustomerRepository;
import com.capgemini.shoppingapp.repository.ProductRepository;
import com.capgemini.shoppingapp.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService
{
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CustomerRepository cusRepo;
	
	@Autowired
	CustomerOrdersRepository orderRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public Products addProductdetails(Products product) throws IOException
	{
		List<Products> all= productRepo.findAll();
		for(Products l : all)
		{
			if(l.getProductid().contentEquals(product.getProductid()))
			{
				LOGGER.info("entered into admin service implementation AddProductdetails method if condition product id already exists: productid: -> {}",product.getProductid());
				return null;
			}
		}
		
		LOGGER.info("entered into admin service implementation AddProductdetails method: product -> {}",product);
		return productRepo.save(product);
		
	}

	@Override
	public String removeproduct(String id) {
		productRepo.deleteById(id);
		LOGGER.info("entered into admin service implementation removeProduct method: id -> {}",id);
		return id;
	}
	
	@Override
	public List<Customer> viewAllCustomers() {
		List<Customer> list = cusRepo.findAll();
		LOGGER.info("entered into admin service implementation viewallcustomers method: All Customers -> {}",list);
        return list;
	}
	
	@Override
	public String removecustomer(String id) {
		cusRepo.deleteById(id);
		LOGGER.info("entered into admin service implementation removecustomer method: id -> {}",id);
		return id;
	}

	@Override
	public List<CustomerOrders> viewallOrders() {
		List<CustomerOrders> list = orderRepo.findAll();
		LOGGER.info("entered into admin service implementation viewallorders method: All Orders -> {}",list);
		return list;
	}

	@Override
	public List<Cart> viewallCarts() {
		List<Cart> list = cartRepo.findAll();
		LOGGER.info("entered into admin service implementation viewallcarts method: All carts -> {}",list);
		
		return list;
	}

	@Override
	public Customer addadmin(Customer cus) {
		List<Customer> all= cusRepo.findAll();
		for(Customer l : all)
		{
			if(l.getEmail().contentEquals(cus.getEmail()))
			{
				LOGGER.info("entered into admin service addadmin method if condition email id is already exists: email -> {}",cus.getEmail());
				return null;
			}
		}
		cus.setPassword(bcryptEncoder.encode(cus.getPassword()));
		LOGGER.info("entered into admin service addadmin method: customer -> {}",cus);
		return cusRepo.save(cus);
	}

	@Override
	public Customer addsalesperson(Customer cus) {
		List<Customer> all= cusRepo.findAll();
		for(Customer l : all)
		{
			if(l.getEmail().contentEquals(cus.getEmail()))
			{
				LOGGER.info("entered into admin service addsalesperson method if condition email id is already exists: email -> {}",cus.getEmail());
				return null;
			}
		}
		cus.setPassword(bcryptEncoder.encode(cus.getPassword()));
		LOGGER.info("entered into admin service addadmin method: customer -> {}",cus);
		return cusRepo.save(cus);
	}
	
	

	


}
