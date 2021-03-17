package com.capgemini.shoppingapp.service;

import java.util.List;

import com.capgemini.shoppingapp.model.CustomerOrders;

public interface SalesService 
{
	public List<CustomerOrders> viewallOrders();
	
	public CustomerOrders updatestatustoshipped(String id);
	
	public String cancelOrder(String id);
	
	public CustomerOrders updatestatustoOutforDelivery(String id);
	
	
	public CustomerOrders updatestatustoDelivered(String id);
	
	public List<CustomerOrders> getlistofstatusshipped();
	
	public List<CustomerOrders> getlistofstatusorderplaced();
	
	public List<CustomerOrders> getlistofstatusoutfordelivery();
	
	public List<CustomerOrders> getlistofstatusdelivered();
	
}
