package com.capgemini;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("springconfig.xml");
		EmployeeDao EDao=(EmployeeDao) context.getBean("empdao");
		EDao.insert(new EmployeePojo(102,"seshu",50000));
		System.out.println();
	}

}
