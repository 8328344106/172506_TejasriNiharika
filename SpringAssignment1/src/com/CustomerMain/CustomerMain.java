package com.CustomerMain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Customer.Customer;

public class CustomerMain {

	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("CusAddBean.xml");
		Customer customer=(Customer) context.getBean("CustomerBean");
		customer.getCustomer();
	}

}
