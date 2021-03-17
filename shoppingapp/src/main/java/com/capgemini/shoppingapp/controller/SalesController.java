package com.capgemini.shoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.service.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController 
{
	
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SalesController.class);
	
	@Autowired
	SalesService saleser;
	
	@PreAuthorize("hasRole('sales')")
	@PostMapping("/viewallOrders")
    public List<CustomerOrders> viewAllCustomers() 
	{
		LOGGER.info("entered into Sales controller view all customers method");
		return saleser.viewallOrders();
    
    }
	
	@PreAuthorize("hasRole('sales')")
	@PostMapping("/getlistofstatusshipped")
    public List<CustomerOrders> getlistofstatusshipped() 
	{
		LOGGER.info("entered into Sales controller getlistofstatusshipped method");
		return saleser.getlistofstatusshipped();
    
    }

	@PreAuthorize("hasRole('sales')")
	@PostMapping("/getlistofstatusorderplaced")
    public List<CustomerOrders> getlistofstatusorderplaced() 
	{
		LOGGER.info("entered into Sales controller getlistofstatusorderplaced method");
		return saleser.getlistofstatusorderplaced();
    
    }

	@PreAuthorize("hasRole('sales')")
	@PostMapping("/getlistofstatusoutfordelivery")
    public List<CustomerOrders> getlistofstatusoutfordelivery() 
	{
		LOGGER.info("entered into Sales controller getlistofstatusoutfordelivery method");
		return saleser.getlistofstatusoutfordelivery();
    
    }

	@PreAuthorize("hasRole('sales')")
	@PostMapping("/getlistofstatusdelivered")
    public List<CustomerOrders> getlistofstatusdelivered() 
	{
		LOGGER.info("entered into Sales controller getlistofstatusdelivered method");
		return saleser.getlistofstatusdelivered();
    
    }
	
	@PreAuthorize("hasRole('sales')")
	@PostMapping(value="/updatestatustoshipped", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public CustomerOrders updatestatustoshipped(@RequestParam("id") String id)
	{
		LOGGER.info("entered into sales controller updatestatustoshipped method -> {} ",id);
		return saleser.updatestatustoshipped(id);
	}
	
	@PreAuthorize("hasRole('sales')")
	@PostMapping(value="/updatestatustoOutforDelivery", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public CustomerOrders updatestatustoOutforDelivery(@RequestParam("id") String id)
	{
		LOGGER.info("entered into sales controller updatestatustoOutforDelivery method -> {} ",id);
		return saleser.updatestatustoOutforDelivery(id);
	}
	
	@PreAuthorize("hasRole('sales')")
	@PostMapping(value="/updatestatustoDelivered", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public CustomerOrders updatestatustoDelivered(@RequestParam("id") String id)
	{
		LOGGER.info("entered into sales controller updatestatustoDelivered method -> {} ",id);
		return saleser.updatestatustoDelivered(id);
	}
	
	@PreAuthorize("hasRole('sales')")
	@DeleteMapping(value="/CancelOrder", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String cancelOrder(@RequestParam("id") String id)
	{
		LOGGER.info("entered into sales controller CancelOrder method -> {} ",id);
		return saleser.cancelOrder(id);
	}
	
	
		
}
