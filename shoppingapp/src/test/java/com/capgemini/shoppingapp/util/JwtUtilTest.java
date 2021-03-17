package com.capgemini.shoppingapp.util;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

class JwtUtilTest {

	private static final String A_SECRET_KEY = "secret";

	@InjectMocks
	JwtUtil undertest;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGeneratedToken_And_Validating_Token() {
		Authentication auth = Mockito.mock(Authentication.class);
		Mockito.when(auth.getName()).thenReturn("sadhvika");
		String token = Jwts.builder().setSubject(auth.getName()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, A_SECRET_KEY).compact();
		assertNotNull(undertest.generateToken(auth));
		UserDetails userDetails = Mockito.mock(UserDetails.class);
		Mockito.when(userDetails.getUsername()).thenReturn("sadhvika");
		assertEquals("sadhvika", undertest.extractUsername(token));
		assertEquals(true, undertest.validateToken(token, userDetails));
	}

}
