package com.capgemini.shoppingapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.capgemini.shoppingapp.filter.JwtFilter;
import com.capgemini.shoppingapp.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SecurityConfig.class);
	
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		LOGGER.info("entered into security config configure method for AuthenticationManagerBuilder");
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		LOGGER.info("entered into security config passwordEncoder method for password encoder");
		return new BCryptPasswordEncoder();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception 
	{
		LOGGER.info("entered into security config authenticationManagerBean method");
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		LOGGER.info("entered into security config configure method for HttpSecurity");
		http.csrf().disable().authorizeRequests()
				.antMatchers("/auth/login", "/customer/registercustomer","/customer/viewallProducts","/customer/getProductById", "/swagger-resources/**", "/configuration/ui",
						"/swagger-ui.html", "/webjars/**", "/v2/api-docs", "/swagger*/**")
				.permitAll().anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	}

}
