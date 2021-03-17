package com.capgemini.shoppingapp.service;

import com.capgemini.shoppingapp.model.Customer;
import com.capgemini.shoppingapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		List<Customer> cus = repository.findAll();
		Customer user = new Customer();
		for (Customer c : cus) {
			if (c.getEmail().equals(username)) 
			{
				LOGGER.info("entered into Customer UserDetails Service  loadUserByUsername method if block: Customer object: -> {}",c);
				user = c;
			}
		}
		User use = new User(user.getEmail(), user.getPassword(),getAuthority(user));
		LOGGER.info("Customer UserDetails Service  loadUserByUsername method: C: -> {}",use);
		return use;
	}
	
	public List<GrantedAuthority> getAuthority(Customer user) {
		 List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        LOGGER.info("entered into Customer UserDetails Service  getAuthority method: list of authorities: -> {}",authorities);
		return authorities;
	}
}
