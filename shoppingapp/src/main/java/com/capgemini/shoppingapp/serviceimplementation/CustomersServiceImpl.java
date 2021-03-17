package com.capgemini.shoppingapp.serviceimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.shoppingapp.model.Cart;
import com.capgemini.shoppingapp.model.Customer;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.model.Products;
import com.capgemini.shoppingapp.repository.CartRepository;
import com.capgemini.shoppingapp.repository.CustomerOrdersRepository;
import com.capgemini.shoppingapp.repository.CustomerRepository;
import com.capgemini.shoppingapp.repository.ProductRepository;
import com.capgemini.shoppingapp.service.CustomersService;

@Service
public class CustomersServiceImpl implements CustomersService
{
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CustomersServiceImpl.class);
	
	@Autowired
	CustomerRepository cusRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	CustomerOrdersRepository ordersRepo;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Override
	public List<Products> viewAllProducts() {
		LOGGER.info("entered into customer service viewAllProducts method: list of all products");
		return productRepo.findAll();
	}

	@Override
	public Customer addcustomer(Customer cus)
	{
		List<Customer> all= cusRepo.findAll();
		for(Customer l : all)
		{
			if(l.getEmail().contentEquals(cus.getEmail()))
			{
				LOGGER.info("entered into customer service addcustomer method if condition email id is already exists: email -> {}",cus.getEmail());
				return null;
			}
		}
		cus.setPassword(bcryptEncoder.encode(cus.getPassword()));
		LOGGER.info("entered into customer service Addcustomer method: customer -> {}",cus);
		return cusRepo.save(cus);
	}

	@Override
	public Customer getCustomerById(String id) {
		Optional<Customer> customer = cusRepo.findById(id);
        if(customer.isPresent()) {
        	 LOGGER.info("entered into customer service getcustomerbyid method if  condition customer id exists: customer -> {}",customer.get());
            return customer.get();
           
        } else {
        	 LOGGER.info("entered into customer service getcustomerbyid method else condition customer id not exists: id -> {}",id);
            return null;
        }
	}

	@Override
	public Customer updatecustomer(Customer customer) 
	{
		 LOGGER.info("entered into customer service updatecustomer method: customer -> {}",customer);
		return cusRepo.save(customer);
	}

	@Override
	public Products getProductsById(String id) {
		Optional<Products> product = productRepo.findById(id);
        if(product.isPresent()) {
        	LOGGER.info("entered into customer service getproductbyid method if  condition customer id exists: product -> {}",product.get());
            return product.get();
        } else {
        	LOGGER.info("entered into customer service getproductbyid method else  condition customer id exists: id -> {}",id);
            return null;
        }
	}

	@Override
	public Cart addproducttocart(String email, Products product) {
		
		List<Cart> all = cartRepo.findAll();
		List<Products> products = new ArrayList<>();
		for(Cart c:all)
		{
			if(c.getEmail().contentEquals(email))
			{
				products = c.getCartitems();
				products.add(product);
				c.setCartitems(products);
				LOGGER.info("entered into customer service addproducttocart method if condition: product -> {}",c);
				return cartRepo.save(c);
			}
		}
		Cart newcart = new Cart();
		newcart.setEmail(email);
		products.add(product);
		newcart.setCartitems(products);
		LOGGER.info("entered into customer service addproduct to cart method: product -> {}",product);
		return cartRepo.save(newcart);
	}

	@Override
	public Cart getCartByEmail(String email) {
		List<Cart> allcart = cartRepo.findAll();
		for(Cart cart:allcart)
		{
			if(cart.getEmail().contentEquals(email))
			{
				LOGGER.info("entered into customer service getcartbyemail method if  condition cart exists for that mail: cart -> {}",cart);
				return cart;
			}
		}
		LOGGER.info("entered into customer service getcartbyemail method else condition cart not exists for that mail: email -> {}",email);
		return null;
	}

	@Override
	public CustomerOrders buyall(String email, CustomerOrders orders) {
		List<Cart> list = cartRepo.findAll();
		for(Cart cart:list)
		{
			if(cart.getEmail().contentEquals(email))
			{
				orders.setOrderditems(cart.getCartitems());
				orders.setEmail(email);
				cartRepo.deleteById(cart.getId());
				LOGGER.info("entered into customer service buyall method if  condition cart for that email exists: order -> {}",orders);
				return ordersRepo.save(orders);
			}
		}
		
		LOGGER.info("entered into customer service buyall method else  condition cart not exists for that email: email -> {}",email);
		return null;
	}

	@Override
	public CustomerOrders buynow(String email, Products product, CustomerOrders orders) 
	{
		ArrayList<Products> item = new ArrayList<>();
		item.add(product);
		orders.setOrderditems(item);
		orders.setEmail(email);
		LOGGER.info("entered into customer service buynow that item method: orders -> {}",orders);
		return ordersRepo.save(orders);
	}

	@Override
	public List<CustomerOrders> getordersbuymail(String email) {
		List<CustomerOrders> list = ordersRepo.findAll();
		List<CustomerOrders> listoforders = new ArrayList<>();
		for(CustomerOrders order:list)
		{
			if(order.getEmail().contentEquals(email))
			{
				
				listoforders.add(order);
			}
		}
		LOGGER.info("entered into customer service getordersbymail method: list of orders -> {}",listoforders);
		return listoforders;
	}

	@Override
	public String cancelorder(String id) {
		ordersRepo.deleteById(id);
		LOGGER.info("entered into customer service cancelorder method: id -> {}",id);
		return id;
	}

	
	
	
	
	

}
