package com.capgemini.shoppingapp.serviceimplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.repository.CustomerOrdersRepository;
import com.capgemini.shoppingapp.service.SalesService;


@Service
public class SalesServiceImpl implements SalesService
{
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SalesServiceImpl.class);
	
	@Autowired
	CustomerOrdersRepository ordersRepo;

	@Override
	public List<CustomerOrders> viewallOrders() {
		List<CustomerOrders> list = ordersRepo.findAll();
		LOGGER.info("entered into sales service implementation viewallorders method: All Orders -> {}",list);
		return list;
	}
	
	@Override
	public List<CustomerOrders> getlistofstatusshipped() 
	{
		List<CustomerOrders> list = ordersRepo.findAll()
									.stream()
									.filter(i -> (i.getStatus().contentEquals("Shipped")))
									.collect(Collectors.toList());
		LOGGER.info("entered into sales service implementation getlistofstatusshipped method: List of Shipped orders -> {}",list);
		return list;
	}

	@Override
	public List<CustomerOrders> getlistofstatusorderplaced() {
		List<CustomerOrders> list = ordersRepo.findAll()
									.stream()
									.filter(i -> (i.getStatus().contentEquals("order placed")))
									.collect(Collectors.toList());
		LOGGER.info("entered into sales service implementation getlistofstatusorderplaced method: List of order placed orders -> {}",list);
		return list;
	}

	@Override
	public List<CustomerOrders> getlistofstatusoutfordelivery() {
		List<CustomerOrders> list = ordersRepo.findAll()
									.stream()
									.filter(i -> (i.getStatus().contentEquals("Out for Delivery")))
									.collect(Collectors.toList());
		LOGGER.info("entered into sales service implementation getlistofstatusoutfordelivery method: List of order placed orders -> {}",list);
		return list;
	}

	@Override
	public List<CustomerOrders> getlistofstatusdelivered() {
		List<CustomerOrders> list = ordersRepo.findAll()
									.stream()
									.filter(i -> (i.getStatus().contentEquals("Delivered")))
									.collect(Collectors.toList());
		LOGGER.info("entered into sales service implementation getlistofstatusdelivered method: List of order placed orders -> {}",list);
		return list;
	}

	@Override
	public CustomerOrders updatestatustoshipped(String id) {
		Optional<CustomerOrders> orders = ordersRepo.findById(id);
		if(orders.isPresent())
		{
			orders.get().setStatus("Shipped");
			LOGGER.info("entered into sales service implementation updatestatustoshipped method if block id is present: order -> {}",orders.get());
			return ordersRepo.save(orders.get());
		}
		
		LOGGER.info("entered into sales service implementation updatestatustoshipped method else block id is not there: id -> {}",id);
		return null;
	}
	
	@Override
	public CustomerOrders updatestatustoOutforDelivery(String id) {
		Optional<CustomerOrders> orders = ordersRepo.findById(id);
		if(orders.isPresent())
		{
			orders.get().setStatus("Out for Delivery");
			LOGGER.info("entered into sales service implementation updatestatustoOutforDelivery method if block id is present: order -> {}",orders);
			return ordersRepo.save(orders.get());
		}
		
		LOGGER.info("entered into sales service implementation updatestatustoOutforDelivery method else block id is not there: id -> {}",id);
		return null;
	}
	
	@Override
	public CustomerOrders updatestatustoDelivered(String id) {
		Optional<CustomerOrders> orders = ordersRepo.findById(id);
		if(orders.isPresent())
		{
			orders.get().setStatus("Delivered");
			LOGGER.info("entered into sales service implementation updatestatustoDelivered method if block id is present: order -> {}",orders);
			return ordersRepo.save(orders.get());
		}
		
		LOGGER.info("entered into sales service implementation updatestatustoDelivered method else block id is not there: id -> {}",id);
		return null;
	}

	@Override
	public String cancelOrder(String id) {
		ordersRepo.deleteById(id);
		LOGGER.info("entered into sales service implementation CancelOrder method: id -> {}",id);
		return id;
	}

	

	
	
}
