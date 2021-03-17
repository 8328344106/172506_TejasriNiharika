package com.capgemini.shoppingapp.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.shoppingapp.model.Cart;
import com.capgemini.shoppingapp.model.Customer;
import com.capgemini.shoppingapp.model.CustomerDTO;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.model.ProductDTO;
import com.capgemini.shoppingapp.model.Products;
import com.capgemini.shoppingapp.service.AdminService;
import com.capgemini.shoppingapp.service.CustomersService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomersService cusservice;

	@Autowired
	AdminService adminservice;

	@PostMapping(value = "/registercustomer")
	public Customer addcustomer(@RequestBody CustomerDTO cus) {
		
		Customer customer = new Customer(cus.getName(), cus.getPassword(), cus.getEmail(), cus.getPhoneNumber(),
				"customer");
		LOGGER.info("entered into customer controller register customer method: customer -> {}", customer);
		return cusservice.addcustomer(customer);
	}

	@PostMapping("/viewallProducts")
	public List<Products> viewAllProducts() {
		LOGGER.info("entered into customer controller view all products method");
		return cusservice.viewAllProducts();
	}

	@PostMapping(value = "/getProductById", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Products getProductsById(@RequestParam("id") String id) 
	{
		LOGGER.info("entered into customer controller get products by id method: Id -> {}", id);
		return cusservice.getProductsById(id);
	}

	@PreAuthorize("hasRole('customer')")
	@PostMapping(value = "/getCustomerById", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Customer getCustomerById(@RequestParam("id") String id) {
		
		LOGGER.info("entered into customer controller get customer by Id method: Id -> {}", id);
		return cusservice.getCustomerById(id);

	}

	@PreAuthorize("hasRole('customer')")
	@PutMapping("/updatecustomer")
	public Customer updatecustomer(@RequestBody CustomerDTO cus) {
		
		Customer customer = new Customer(cus.getId(), cus.getName(), cus.getPassword(), cus.getEmail(),
				cus.getPhoneNumber());

		LOGGER.info("entered into customer controller update customer method: customer -> {}", customer);
		return cusservice.updatecustomer(customer);

	}

	@PreAuthorize("hasRole('customer')")
	@PostMapping(value = "/addproducttocart/{email}")
	public Cart addproducttocart(@PathVariable("email") String email, @RequestBody ProductDTO product) {
		
		Products product1 = new Products(product.getId(), product.getPrice(),
				product.getProductid(), product.getProductname(), product.getProducttype());
		
		LOGGER.info("entered into customer controller add product to cart method: email -> {} ", email);
		LOGGER.info("product -> {}",product1);
		
		return cusservice.addproducttocart(email, product1);
	}

	@PreAuthorize("hasRole('customer')")
	@PostMapping(value = "/getCartByEmail", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Cart getcartbuymail(@RequestParam("email") String email) 
	{
		
		LOGGER.info("entered into Customer controller get cart by email method: email -> {}", email);
		return cusservice.getCartByEmail(email);

	}
	
	

	@PreAuthorize("hasRole('customer')")
	@PostMapping(value = "/buyall")
	public CustomerOrders buyall(@RequestParam("email") String email, @RequestParam("cardnumber") BigInteger cardnumber,
			@RequestParam("cvv") int cvv, @RequestParam("expmon") int expmon, @RequestParam("expyear") int expyear) {

		CustomerOrders orders = new CustomerOrders(cardnumber, cvv, expmon, expyear,"order placed");
		LOGGER.info("entered into customer controller buy all car items method: card details -> {}", orders);
		LOGGER.info("email -> {} ", email);
		return cusservice.buyall(email, orders);
	}

	@PreAuthorize("hasRole('customer')")
	@PostMapping(value = "/buynow")
	public CustomerOrders buynow(@RequestParam("email") String email, @RequestParam("cardnumber") BigInteger cardnumber,
			@RequestParam("cvv") int cvv, @RequestParam("expmon") int expmon, @RequestParam("expyear") int expyear,
			@RequestBody ProductDTO product) {

		Products item = new Products(product.getId(), product.getPrice(),
				product.getProductid(), product.getProductname(), product.getProducttype());
		CustomerOrders orders = new CustomerOrders(cardnumber, cvv, expmon, expyear,"order placed");
		LOGGER.info("entered into customer controller buy now product method: item -> {}", item);
		LOGGER.info("email -> {}", email);
		LOGGER.info("card details -> {}", orders);
		return cusservice.buynow(email, item, orders);
	}

	@PreAuthorize("hasRole('customer')")
	@PostMapping(value = "/getordersbyemail", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public List<CustomerOrders> getordersbuymail(@RequestParam("email") String email) {
		LOGGER.info("entered into customer controller getorderbyemail method: email -> {}", email);
		return cusservice.getordersbuymail(email);

	}

	@PreAuthorize("hasRole('customer')")
	@DeleteMapping(value = "/cancelorder", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String cancelorder(@RequestParam("id") String id) {
		LOGGER.info("entered into customer controller cancel order method: id -> {}", id);
		return cusservice.cancelorder(id);
	}

}
