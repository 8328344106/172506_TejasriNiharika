package com.capgemini.shoppingapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.model.Products;
import com.capgemini.shoppingapp.repository.CustomerOrdersRepository;
import com.capgemini.shoppingapp.serviceimplementation.SalesServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class SalesServiceTest 
{
	
	@InjectMocks
	SalesServiceImpl saleserv;
	
	@Mock
	private CustomerOrdersRepository orderRepo;
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testviewallOrders() {
		
		List<Products> product = new ArrayList<>();
		product.add( new Products("12847hhd", "mobile", "mi", "1", "8797"));
		BigInteger b1 = new BigInteger("1321");
		when(orderRepo.findAll())
		.thenReturn(Stream.of(new CustomerOrders("123fd","niha@gmail.com",product, b1,123, 12, 2021,"order placed"))
						.collect(Collectors.toList()));
		assertEquals(1, saleserv.viewallOrders().size());

	}
	
	@Test
	void testupdatestatustoshipped() {
		
		List<Products> product = new ArrayList<>();
		product.add( new Products("12847hhd", "mobile", "mi", "1", "8797"));
		BigInteger b1 = new BigInteger("1321");
		CustomerOrders order = new CustomerOrders("123fd","niha@gmail.com",product, b1,123, 12, 2021,"Shipped");
		String id = "123fd";
		when(orderRepo.findById(id)).thenReturn(Optional.of(order));
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(order, saleserv.updatestatustoshipped(id));

	}
	
	@Test
	void testupdatestatustoshipped_NullCase() 
	{
		
		String id = "678908";
		when(orderRepo.findById(id)).thenReturn(Optional.empty());
		assertEquals(null, saleserv.updatestatustoshipped(id));

	}
	
	@Test
	void testupdatestatustoOutforDelivery() {
		
		List<Products> product = new ArrayList<>();
		product.add( new Products("12847hhd", "mobile", "mi", "1", "8797"));
		BigInteger b1 = new BigInteger("1321");
		CustomerOrders order = new CustomerOrders("123fd","niha@gmail.com",product, b1,123, 12, 2021,"Out for Delivery");
		String id = "123fd";
		when(orderRepo.findById(id)).thenReturn(Optional.of(order));
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(order, saleserv.updatestatustoOutforDelivery(id));

	}
	
	@Test
	void testupdatestatustoOutforDelivery_NullCase() 
	{
		
		String id = "678908";
		when(orderRepo.findById(id)).thenReturn(Optional.empty());
		assertEquals(null, saleserv.updatestatustoOutforDelivery(id));

	}
	
	@Test
	void testupdatestatustoDelivered() {
		
		List<Products> product = new ArrayList<>();
		product.add( new Products("12847hhd", "mobile", "mi", "1", "8797"));
		BigInteger b1 = new BigInteger("1321");
		CustomerOrders order = new CustomerOrders("123fd","niha@gmail.com",product, b1,123, 12, 2021,"Delivered");
		String id = "123fd";
		when(orderRepo.findById(id)).thenReturn(Optional.of(order));
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(order, saleserv.updatestatustoDelivered(id));

	}
	
	@Test
	void testupdatestatustoDelivered_NullCase() 
	{
		
		String id = "678908";
		when(orderRepo.findById(id)).thenReturn(Optional.empty());
		assertEquals(null, saleserv.updatestatustoDelivered(id));

	}
	

	@Test
	void testgetlistofstatusshipped() {
		
		List<Products> product = new ArrayList<>();
		product.add( new Products("12847hhd", "mobile", "mi", "1", "8797"));
		BigInteger b1 = new BigInteger("1321");
		when(orderRepo.findAll())
		.thenReturn(Stream.of(new CustomerOrders("123fd","niha@gmail.com",product, b1,123, 12, 2021,"Shipped"))
						.collect(Collectors.toList()));
		assertEquals(1, saleserv.getlistofstatusshipped().size());

	}
	
	@Test
	void testgetlistofstatusorderplaced() {
		
		List<Products> product = new ArrayList<>();
		product.add( new Products("12847hhd", "mobile", "mi", "1", "8797"));
		BigInteger b1 = new BigInteger("1321");
		when(orderRepo.findAll())
		.thenReturn(Stream.of(new CustomerOrders("123fd","niha@gmail.com",product, b1,123, 12, 2021,"order placed"))
						.collect(Collectors.toList()));
		assertEquals(1, saleserv.getlistofstatusorderplaced().size());

	}
	
	@Test
	void testgetlistofstatusoutfordelivery() {
		
		List<Products> product = new ArrayList<>();
		product.add( new Products("12847hhd", "mobile", "mi", "1", "8797"));
		BigInteger b1 = new BigInteger("1321");
		when(orderRepo.findAll())
		.thenReturn(Stream.of(new CustomerOrders("123fd","niha@gmail.com",product, b1,123, 12, 2021,"Out for Delivery"))
						.collect(Collectors.toList()));
		assertEquals(1, saleserv.getlistofstatusoutfordelivery().size());

	}
	
	@Test
	void testgetlistofstatusdelivered() {
		
		List<Products> product = new ArrayList<>();
		product.add( new Products("12847hhd", "mobile", "mi", "1", "8797"));
		BigInteger b1 = new BigInteger("1321");
		when(orderRepo.findAll())
		.thenReturn(Stream.of(new CustomerOrders("123fd","niha@gmail.com",product, b1,123, 12, 2021,"Delivered"))
						.collect(Collectors.toList()));
		assertEquals(1, saleserv.getlistofstatusdelivered().size());

	}
	
	@Test
	void testremoveproduct() {
		String id = "45678bsjgj";
		saleserv.cancelOrder(id);
		verify(orderRepo, times(1)).deleteById(id);
	}
}
