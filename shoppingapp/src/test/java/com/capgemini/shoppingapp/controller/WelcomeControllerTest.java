package com.capgemini.shoppingapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capgemini.shoppingapp.filter.JwtFilter;
import com.capgemini.shoppingapp.model.AuthRequest;
import com.capgemini.shoppingapp.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class WelcomeControllerTest 
{
	@MockBean
	JwtUtil jwtUtil;
	
	@Autowired
	JwtFilter filter;
	
	@MockBean
	AuthenticationManager authenticationManager;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders
			        .webAppContextSetup(webApplicationContext)
			        .addFilters(filter)
			        //.apply(springSecurity())
			        .build();
	}

	@Test
	void testgenerateToken() throws Exception {
	AuthRequest req = new AuthRequest("niha@gmail.com","fjkhg");
		this.mockMvc
		.perform(post("/auth/login").content(mapper.writeValueAsString(req))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
