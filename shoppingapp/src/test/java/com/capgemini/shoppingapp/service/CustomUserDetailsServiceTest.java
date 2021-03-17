package com.capgemini.shoppingapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.shoppingapp.model.Customer;
import com.capgemini.shoppingapp.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomUserDetailsServiceTest {
	
	@InjectMocks
	CustomUserDetailsService service;
	
	@Mock
	private CustomerRepository cusRepo;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	
	void test() {
		when(cusRepo.findAll()).thenReturn(Stream
				.of(new Customer("1", "niha", "niha1208", "niha1@gmail.com", "8987654511","customer"),
						new Customer("2", "teja", "mouni@gmail.com", "Kolkata", "8982354567","customer"))
				.collect(Collectors.toList()));
		assertEquals("niha1@gmail.com", service.loadUserByUsername("niha1@gmail.com").getUsername());
		assertEquals("niha1208", service.loadUserByUsername("niha1@gmail.com").getPassword());
		assertEquals("[ROLE_customer]", service.loadUserByUsername("niha1@gmail.com").getAuthorities().toString());
		
	}

}
