package com.capgemini.shoppingapp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
import com.capgemini.shoppingapp.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTest {
	
	@MockBean
	AdminService adminService;
	
	@Autowired
	private MockMvc mockMvc;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Test
	@WithMockUser(roles="admin")
	void testaddProductdetails() throws Exception
	{
		String productid= "Mok123";
		String producttype="Mobile";
		String productname="Samsung";
		String price = "1288";
		Products pro =  new Products(productid,producttype,productname,price);
		when(adminService.addProductdetails(pro)).thenReturn(pro);
		this.mockMvc.perform(post("/admin/addProduct")
					.param("productid", productid)
					.param("producttype", producttype)
					.param("productname", productname)
					.param("price", price)
					.contentType(MediaType.MULTIPART_FORM_DATA_VALUE) .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
		
	}
	
	@Test
	@WithMockUser(roles="admin")
	void testremoveproduct() throws Exception
	{
		String id = "sgdhga";
		when(adminService.removeproduct(id)).thenReturn(id);
		this.mockMvc.perform(delete("/admin/removeproduct")
				.param("id",id)
				.contentType(MediaType.MULTIPART_FORM_DATA_VALUE )
				.accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="admin")
	void testremovecustomer() throws Exception
	{
		String id = "987657";
		when(adminService.removecustomer(id)).thenReturn(id);
		this.mockMvc.perform(delete("/admin/removecustomer")
				.param("id", id)
				.contentType(MediaType.MULTIPART_FORM_DATA_VALUE )
				.accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="admin")
	void testviewAllCustomers() throws Exception
	{
		when(adminService.viewAllCustomers()).thenReturn(Stream.of(new Customer("1","niha","niha1208","niha@gmail.com","8987654511"),new Customer("2","teja","mouni@gmail.com","Kolkata","8982354567")).
				  collect(Collectors.toList()));
		this.mockMvc.perform((post("/admin/viewallCustomers")).contentType("application/json"))
	      .andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="admin")
	void testviewallOrders() throws Exception
	{
		when(adminService.viewallOrders()).thenReturn(Stream.of(new CustomerOrders()).
				  collect(Collectors.toList()));
		this.mockMvc.perform((post("/admin/viewallOrders")).contentType("application/json"))
	      .andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="admin")
	void testviewallCarts() throws Exception
	{
		when(adminService.viewallCarts()).thenReturn(Stream.of(new Cart()).
				  collect(Collectors.toList()));
		this.mockMvc.perform((post("/admin/viewallCarts")).contentType("application/json"))
	      .andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="admin")
	void testaddcustomer() throws Exception {
		Customer customer = new Customer("niha", "niha1208", "niha1@gmail.com", "8797776768");
		when(adminService.addadmin(customer)).thenReturn(customer);
		this.mockMvc
				.perform(post("/admin/registeradmin").content(mapper.writeValueAsString(customer))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
