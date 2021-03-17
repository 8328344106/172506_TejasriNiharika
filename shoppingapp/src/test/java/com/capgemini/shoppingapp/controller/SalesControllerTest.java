package com.capgemini.shoppingapp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.service.SalesService;

@SpringBootTest
@AutoConfigureMockMvc
class SalesControllerTest {

	@MockBean
	SalesService saleservice;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@WithMockUser(roles="sales")
	void testviewallOrders() throws Exception
	{
		when(saleservice.viewallOrders()).thenReturn(Stream.of(new CustomerOrders()).
				  collect(Collectors.toList()));
		this.mockMvc.perform((post("/sales/viewallOrders")).contentType("application/json"))
	      .andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="sales")
	void testgetlistofstatusdelivered() throws Exception
	{
		when(saleservice.getlistofstatusdelivered()).thenReturn(Stream.of(new CustomerOrders()).
				  collect(Collectors.toList()));
		this.mockMvc.perform((post("/sales/getlistofstatusdelivered")).contentType("application/json"))
	      .andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="sales")
	void testgetlistofstatusorderplaced() throws Exception
	{
		when(saleservice.getlistofstatusorderplaced()).thenReturn(Stream.of(new CustomerOrders()).
				  collect(Collectors.toList()));
		this.mockMvc.perform((post("/sales/getlistofstatusorderplaced")).contentType("application/json"))
	      .andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="sales")
	void testgetlistofstatusoutfordelivery() throws Exception
	{
		when(saleservice.getlistofstatusoutfordelivery()).thenReturn(Stream.of(new CustomerOrders()).
				  collect(Collectors.toList()));
		this.mockMvc.perform((post("/sales/getlistofstatusoutfordelivery")).contentType("application/json"))
	      .andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="sales")
	void testgetlistofstatusshipped() throws Exception
	{
		when(saleservice.getlistofstatusshipped()).thenReturn(Stream.of(new CustomerOrders()).
				  collect(Collectors.toList()));
		this.mockMvc.perform((post("/sales/getlistofstatusshipped")).contentType("application/json"))
	      .andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="sales")
	void testupdatestatustoDelivered() throws Exception {
		String id = "jhDJHSJH";
		when(saleservice.updatestatustoDelivered(id)).thenReturn(new CustomerOrders());
		this.mockMvc
				.perform(post("/sales/updatestatustoDelivered").param("id", id)
						.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="sales")
	void testupdatestatustoOutforDelivery() throws Exception {
		String id = "jhDJHSJH";
		when(saleservice.updatestatustoOutforDelivery(id)).thenReturn(new CustomerOrders());
		this.mockMvc
				.perform(post("/sales/updatestatustoOutforDelivery").param("id", id)
						.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="sales")
	void testupdatestatustoshipped() throws Exception {
		String id = "jhDJHSJH";
		when(saleservice.updatestatustoshipped(id)).thenReturn(new CustomerOrders());
		this.mockMvc
				.perform(post("/sales/updatestatustoshipped").param("id", id)
						.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles="sales")
	void testCancelOrder() throws Exception {
		String id = "sgdhga";
		when(saleservice.cancelOrder(id)).thenReturn(id);
		this.mockMvc.perform(delete("/sales/CancelOrder")
				.param("id", id)
				.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
