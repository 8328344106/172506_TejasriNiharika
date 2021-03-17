package com.capgemini.shoppingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.shoppingapp.model.AuthRequest;
import com.capgemini.shoppingapp.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class WelcomeController {

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(WelcomeController.class);
	
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception 
    {
    	LOGGER.info("entered into welcome controller generateToken method: AuthRequest -> {}",authRequest);
    	try {
    		
        	final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                    		authRequest.getUsername(),
                    		authRequest.getPassword()
                    )
            );
        	LOGGER.info("entered into welcome controller generateToken method try block: authentication: -> {}",authentication);
        	return jwtUtil.generateToken(authentication);
    	} catch (Exception ex) {
    		LOGGER.info("entered into welcome controller generateToken method catch block");
            throw new Exception("inavalid username/password");
        }
    }
}
