package com.capgemini.shoppingapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.shoppingapp.model.Cart;
import com.capgemini.shoppingapp.model.Customer;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.model.Products;
import com.capgemini.shoppingapp.repository.CartRepository;
import com.capgemini.shoppingapp.repository.CustomerOrdersRepository;
import com.capgemini.shoppingapp.repository.CustomerRepository;
import com.capgemini.shoppingapp.repository.ProductRepository;
import com.capgemini.shoppingapp.serviceimplementation.AdminServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceTest {

	@InjectMocks
	AdminServiceImpl adminserv;
	
	@Mock
	private ProductRepository productRepo;
	
	@Mock
	private CustomerRepository cusRepo;
	
	@Mock
	private CustomerOrdersRepository orderRepo;
	
	@Mock
	private CartRepository cartRepo;
	
	@Mock
	BCryptPasswordEncoder encoder;

	@Test
	void testaddProductdetails() throws IOException {
	
		String productid= "Mok123";
		String producttype="Mobile";
		String productname="Samsung";
		String price = "1288";
		Products product =  new Products(productid,producttype,productname,price);
		when(productRepo.findAll()).thenReturn(Stream.of(new Products("4567","phone","mi","12")).
				  collect(Collectors.toList()));
		when(productRepo.save(product)).thenReturn(product);
		assertEquals(product,adminserv.addProductdetails(product));
		
	}
	
	@Test
	void testaddProductdetails_NullCase() throws IOException {
//		MockMultipartFile file 
//	      = new MockMultipartFile(
//	        "file", 
//	        "hello.txt", 
//	        MediaType.TEXT_PLAIN_VALUE, 
//	        "Hello, World!".getBytes()
//	     );
		String productid= "Mok123";
		String producttype="Mobile";
		String productname="Samsung";
		String price = "1288";
		Products product =  new Products(producttype,productname,productid,price);
		when(productRepo.findAll()).thenReturn(Stream.of(new Products("phone","mi","Mok123","12000")).
				  collect(Collectors.toList()));
		when(productRepo.save(product)).thenReturn(product);
		assertEquals(null,adminserv.addProductdetails(product));
		
	}
	
	@Test
	void testremoveproduct() {
		String id = "45678bsjgj";
		adminserv.removeproduct(id);
		verify(productRepo, times(1)).deleteById(id);
	}

	@Test
	void testremovecustomer() {
		String id = "45678bsrg";
		adminserv.removecustomer(id);
		verify(cusRepo, times(1)).deleteById(id);
	}
	
	@Test
	void testviewallOrders() {
		
		List<Products> product = new ArrayList<>();
		product.add( new Products("12847hhd", "mobile", "mi", "1", "8797"));
		BigInteger b1 = new BigInteger("1321");
		when(orderRepo.findAll())
		.thenReturn(Stream.of(new CustomerOrders("123fd","niha@gmail.com",product, b1,123, 12, 2021,"order placed"))
						.collect(Collectors.toList()));
		assertEquals(1, adminserv.viewallOrders().size());

	}
	
	@Test
	void testviewallCarts() {
		
		List<Products> product = new ArrayList<>();
		product.add( new Products("12847hhd", "mobile", "mi", "1", "8797"));
		when(cartRepo.findAll())
		.thenReturn(Stream.of(new Cart("123fd","niha@gmail.com",product),new Cart("123fdty","niha@gmail.com",product))
						.collect(Collectors.toList()));
		assertEquals(2, adminserv.viewallCarts().size());

	}
	
	@Test
	void viewAllCustomers() {
		when(cusRepo.findAll())
		.thenReturn(Stream.of(new Customer("123fd","niha","nha1208","niha@gmail.com","988765456"),new Customer("123fdfg","niha","nha1208","niha1@gmail.com","988765456"))
						.collect(Collectors.toList()));
		assertEquals(2, adminserv.viewAllCustomers().size());

	}
	
	@Test
	void testaddadmin() {
		
		Customer customer = new Customer("niha", "niha1208", "niha1@gmail.com", "8797776768","customer");
		when(cusRepo.save(customer)).thenReturn(customer);
		when(encoder.encode(customer.getPassword())).thenReturn(customer.getPassword());
		assertEquals(customer, adminserv.addadmin(customer));

	}

	@Test
	void testaddadminNullCase() {
		Customer customer = new Customer("niha", "niha1208", "niha1@gmail.com", "8797776768");
		when(cusRepo.findAll()).thenReturn(Stream
				.of(new Customer("1", "niha", "niha1208", "niha1@gmail.com", "8987654511","admin"),
						new Customer("2", "teja", "mouni@gmail.com", "Kolkata", "8982354567","customer"))
				.collect(Collectors.toList()));
		when(cusRepo.save(customer)).thenReturn(null);
		assertEquals(null, adminserv.addadmin(customer));
	}

}
