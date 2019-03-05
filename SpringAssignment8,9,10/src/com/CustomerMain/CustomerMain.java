package com.CustomerMain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Customer.Customer;

public class CustomerMain {

	public static void main(String[] args) 
	{
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("CusAddBean.xml");
		context.registerShutdownHook();
		Customer customer=(Customer) context.getBean("CustomerBean");
		customer.getCustomer();
	}

}
