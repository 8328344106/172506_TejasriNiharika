package com.capgemini.shoppingapp.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import com.capgemini.shoppingapp.model.Cart;
import com.capgemini.shoppingapp.model.Customer;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.model.Products;
import com.capgemini.shoppingapp.service.CustomersService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

	@MockBean
	CustomersService service;

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser
	void testaddcustomer() throws Exception {
		Customer customer = new Customer("niha", "niha1208", "niha1@gmail.com", "8797776768");
		when(service.addcustomer(customer)).thenReturn(customer);
		this.mockMvc
				.perform(post("/customer/registercustomer").content(mapper.writeValueAsString(customer))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser
	void testviewAllProducts() throws Exception {
		
		when(service.viewAllProducts()).thenReturn(Stream.of(new Products("jkh13", "Mobile", "samsung", "30000"),
				new Products("jkh13", "Mobile", "samsung", "66676")).collect(Collectors.toList()));
		this.mockMvc.perform(post("/customer/viewallProducts")
				.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser
	void testgetProductById() throws Exception {
		String id = "jhDJHSJH";
		when(service.getCustomerById(id)).thenReturn(new Customer());
		this.mockMvc
				.perform(post("/customer/getProductById").param("id", id)
						.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	@Test
	@WithMockUser(roles="customer")
	void testgetCustomerById() throws Exception {
		String id = "jhDJHSJH";
		when(service.getCustomerById(id)).thenReturn(new Customer());
		this.mockMvc
				.perform(post("/customer/getCustomerById").param("id", id)
						.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles="customer")
	void testupdatecustomer() throws Exception {
		Customer customer = new Customer("gdashgd", "niha", "niha1208", "niha1@gmail.com", "8797776768");
		when(service.updatecustomer(customer)).thenReturn(customer);
		this.mockMvc
				.perform(put("/customer/updatecustomer").content(mapper.writeValueAsString(customer))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	

	@Test
	@WithMockUser(roles="customer")
	void testaddproducttocart() throws Exception {
		
		String email = "niha@gmail.com";
		Products product = new Products("12847hhd", "mobile", "mi", "1", "8797");
		when(service.addproducttocart(email, product)).thenReturn(new Cart());
		this.mockMvc.perform(post("/customer/addproducttocart/niha@gmail.com")
				.content(mapper.writeValueAsString(product)).contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles="customer")
	void testgetCartByEmail() throws Exception {
		String email = "niha12@gmail.com";
		when(service.getCartByEmail(email)).thenReturn(new Cart());
		this.mockMvc
				.perform(post("/customer/getCartByEmail").param("email", email)
						.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles="customer")
	void testbuyall() throws Exception {
		String bigint = "3456787655";
		BigInteger cardnumber = new BigInteger(bigint);
		int cvv = 768;
		int expmon = 9;
		int expyear = 2023;
		String status = "order placed";
		CustomerOrders orders = new CustomerOrders(cardnumber, cvv, expmon, expyear,status);
		String email = "niha1331@gmail.com";
		when(service.buyall(email, orders)).thenReturn(orders);
		this.mockMvc.perform(post("/customer/buyall")
				.param("cardnumber", bigint)
				.param("cvv", "768")
				.param("expmon", "9")
				.param("expyear", "2023")
				.param("email", email)
				.contentType("application/json"))
		.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles="customer")
	void testbuynow() throws Exception {
		String bigint = "3456787655";
		BigInteger cardnumber = new BigInteger(bigint);
		int cvv = 768;
		int expmon = 9;
		int expyear = 2023;
		String status = "order placed";
		CustomerOrders orders = new CustomerOrders(cardnumber, cvv, expmon, expyear,status);
		Products product = new Products("12847hhd", "mobile", "mi", "1", "8797");
		String email = "niha1331@gmail.com";
		when(service.buynow(email, product, orders)).thenReturn(orders);
		this.mockMvc.perform(post("/customer/buynow")
				.param("cardnumber", bigint)
				.param("cvv", "768")
				.param("expmon", "9")
				.param("expyear", "2023")
				.param("email", email)
				.content(mapper.writeValueAsBytes(product))
				.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles="customer")
	void testgetordersbuymail() throws Exception {
		String email = "niha12@gmail.com";
		when(service.getordersbuymail(email))
				.thenReturn(Stream.of(new CustomerOrders()).collect(Collectors.toList()));
		this.mockMvc.perform(post("/customer/getordersbyemail")
				.param("email", email)
				.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles="customer")
	void testcancelorder() throws Exception {
		String id = "sgdhga";
		when(service.cancelorder(id)).thenReturn(id);
		this.mockMvc.perform(delete("/customer/cancelorder")
				.param("id", id)
				.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
