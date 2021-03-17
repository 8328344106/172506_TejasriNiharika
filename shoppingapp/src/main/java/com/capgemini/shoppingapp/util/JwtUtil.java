package com.capgemini.shoppingapp.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtUtil {

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JwtUtil.class);

	private String secret = "secret";

	public String extractUsername(String token) {
		LOGGER.info("entered into extractUsername method.");
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		LOGGER.info("entered into extractExpiration method.");
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		LOGGER.info("entered into extractClaim method.");
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		LOGGER.info("entered into extractAllClaims method.");
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		LOGGER.info("entered into isTokenExpired method.");
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(Authentication authentication) {
		LOGGER.info("entered into generateToken method.");
		return createToken(authentication.getName());
	}

	private String createToken(String subject) {
		LOGGER.info("entered into createToken method.");
		return Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {

		LOGGER.info("entered into validateToken method.");
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
