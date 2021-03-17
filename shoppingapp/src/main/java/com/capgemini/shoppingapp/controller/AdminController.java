package com.capgemini.shoppingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.shoppingapp.model.Cart;
import com.capgemini.shoppingapp.model.Customer;
import com.capgemini.shoppingapp.model.CustomerDTO;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.model.Products;
import com.capgemini.shoppingapp.service.AdminService;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminser;

	@PreAuthorize("hasRole('admin')")
	@PostMapping(value = "/addProduct", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Products addProductdetails(@RequestParam("productid") String productid, @RequestParam("price") String price,
			@RequestParam("producttype") String producttype, @RequestParam("productname") String productname) throws IOException {

		Products product = new Products(producttype, productname,productid, price);
		LOGGER.info("entered into admin controller Add Product method -> {}",product);
		return adminser.addProductdetails(product);
	}

	
	@PreAuthorize("hasRole('admin')")
	@DeleteMapping(value="/removeproduct", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String removeproduct(@RequestParam("id") String id)
	{
		LOGGER.info("entered into admin controller removeproduct method -> {} ",id);
		return adminser.removeproduct(id);
		
	}
	
	@PreAuthorize("hasRole('admin')")
	@PostMapping("/viewallCustomers")
    public List<Customer> viewAllCustomers() 
	{
		LOGGER.info("entered into Admin controller view all customers method");
		return adminser.viewAllCustomers();
    }
	
	
	@PreAuthorize("hasRole('admin')")
	@DeleteMapping(value="/removecustomer",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public String removecustomer(@RequestParam("id") String id)
    {
		
		LOGGER.info("entered into admin controller remove customer method -> {}",id);
		return adminser.removecustomer(id);
    
    }
	
	
	@PreAuthorize("hasRole('admin')")
	@PostMapping("/viewallOrders")
	public List<CustomerOrders> viewallOrders()
	{
		LOGGER.info("entered into Admin controller view all orders method");
		return adminser.viewallOrders();
	}
	
	@PreAuthorize("hasRole('admin')")
	@PostMapping("/viewallCarts")
	public List<Cart> viewallCarts()
	{
		LOGGER.info("entered into Admin controller view all carts method");
		return adminser.viewallCarts();
		
	
	}
	
	@PreAuthorize("hasRole('admin')")
	@PostMapping(value="/registeradmin")
	public Customer addadmin(@RequestBody CustomerDTO cus)
	{
		Customer customer = new Customer(cus.getName(),cus.getPassword(),cus.getEmail(),cus.getPhoneNumber(),"admin");
		LOGGER.info("entered into Admin controller register admin method: customer -> {}",customer);
		return adminser.addadmin(customer);	
	}
	
	
	@PreAuthorize("hasRole('admin')")
	@PostMapping(value="/registersalesperson")
	public Customer addsalesperson(@RequestBody CustomerDTO cus)
	{
		Customer customer = new Customer(cus.getName(),cus.getPassword(),cus.getEmail(),cus.getPhoneNumber(),"sales");
		LOGGER.info("entered into Admin controller register admin method: customer -> {}",customer);
		return adminser.addsalesperson(customer);	
	}

}
