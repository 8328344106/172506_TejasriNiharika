package com.capgemini.shoppingapp.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.capgemini.shoppingapp.service.CustomUserDetailsService;
import com.capgemini.shoppingapp.util.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JwtFilter.class);
	
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private CustomUserDetailsService service;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    	LOGGER.info("entered into JwtFilter doFilterInternal method");
        String authorizationHeader = httpServletRequest.getHeader("Authorization");

        String token = null;
        String username = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
        	LOGGER.info("entered into JwtFilter doFilterInternal method if block for authorizationHeader != null && authorizationHeader.startsWith(\"Bearer \")");
            token = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(token);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

        	LOGGER.info("entered into JwtFilter doFilterInternal method if block for username != null && SecurityContextHolder.getContext().getAuthentication() == null");
            UserDetails userDetails = service.loadUserByUsername(username);

            if (Boolean.TRUE.equals(jwtUtil.validateToken(token, userDetails))) {

            	
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                LOGGER.info("entered into JwtFilter doFilterInternal method if block for Boolean.TRUE.equals(jwtUtil.validateToken(token, userDetails)): usernamePasswordAuthenticationToken -> {}",usernamePasswordAuthenticationToken);
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        LOGGER.info("entered into JwtFilter doFilterInternal method filterchain");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
