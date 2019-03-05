package com.capgemini;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao 
{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int insert(EmployeePojo emp)
	{
		 String query="insert into employee values('"+emp.getId()+"','"+emp.getName()+"','"+emp.getSalary()+"')";  
		return jdbcTemplate.update(query);  
	}
}
