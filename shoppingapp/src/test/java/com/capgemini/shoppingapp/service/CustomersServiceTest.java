package com.capgemini.shoppingapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.shoppingapp.model.Cart;
import com.capgemini.shoppingapp.model.Customer;
import com.capgemini.shoppingapp.model.CustomerOrders;
import com.capgemini.shoppingapp.model.Products;
import com.capgemini.shoppingapp.repository.CartRepository;
import com.capgemini.shoppingapp.repository.CustomerOrdersRepository;
import com.capgemini.shoppingapp.repository.CustomerRepository;
import com.capgemini.shoppingapp.repository.ProductRepository;
import com.capgemini.shoppingapp.serviceimplementation.CustomersServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomersServiceTest {

	@InjectMocks
	private CustomersServiceImpl service;

	@Mock
	private CustomerRepository cusRepo;

	@Mock
	private ProductRepository productRepo;

	@Mock
	private CartRepository cartRepo;
	
	@Mock
	BCryptPasswordEncoder encoder;

	@Mock
	private CustomerOrdersRepository orderRepo;

	@BeforeEach
	void setup() throws Exception {

	}

	@Test
	void testaddcustomer() {
		
		Customer customer = new Customer("niha", "niha1208", "niha1@gmail.com", "8797776768","customer");
		when(cusRepo.save(customer)).thenReturn(customer);
		when(encoder.encode(customer.getPassword())).thenReturn(customer.getPassword());
		assertEquals(customer, service.addcustomer(customer));

	}

	@Test
	void testsaveCustomerNullCase() {
		Customer customer = new Customer("niha", "niha1208", "niha1@gmail.com", "8797776768");
		when(cusRepo.findAll()).thenReturn(Stream
				.of(new Customer("1", "niha", "niha1208", "niha1@gmail.com", "8987654511","customer"),
						new Customer("2", "teja", "mouni@gmail.com", "Kolkata", "8982354567","customer"))
				.collect(Collectors.toList()));
		when(cusRepo.save(customer)).thenReturn(null);
		assertEquals(null, service.addcustomer(customer));
	}

	@Test
	void testgetCustomerById() {
		String id = "12847hhd";
		Customer customer = new Customer("12847hhd", "niha", "niha1208", "niha@gmail.com", "8797776768","customer");
		when(cusRepo.findById(id)).thenReturn(Optional.of(customer));
		assertEquals(customer, service.getCustomerById(id));
	}

	@Test
	void testgetCustomerByIdNullCase() {
		String id = "12847h";
		when(cusRepo.findById(id)).thenReturn(Optional.empty());
		assertEquals(null, service.getCustomerById(id));
	}

	@Test
	void testupdatecustomer() {
		Customer customer = new Customer("12847hhd", "niha1", "niha1208", "niha@gmail.com", "8797776768","customer");
		when(cusRepo.save(customer)).thenReturn(customer);
		assertEquals(customer, service.updatecustomer(customer));
	}

	@Test
	void testgetProductById() {
		String id = "1233";
		Products product = new Products("12847hhd", "mobile", "mi", "1", "8797");
		when(productRepo.findById(id)).thenReturn(Optional.of(product));
		assertEquals(product, service.getProductsById(id));
	}

	@Test
	void testgetProductByIdNullCase() {
		String id = "12847h";
		when(productRepo.findById(id)).thenReturn(Optional.empty());
		assertEquals(null, service.getProductsById(id));
	}

	@Test
	void testviewAllProducts() {
		when(productRepo.findAll())
				.thenReturn(Stream.of(new Products("12847hhd", "mobile", "mi", "1", "8797"))
						.collect(Collectors.toList()));
		assertEquals(1, service.viewAllProducts().size());

	}

	@Test
	void testaddproducttocart() {
		Products product = new Products("12847hhd", "mobile", "mi", "1", "8797");
		ArrayList<Products> list = new ArrayList<>();
		list.add(product);

		when(cartRepo.findAll())
				.thenReturn(Stream.of(new Cart("1233", "niha123@gmail.com", list)).collect(Collectors.toList()));
		Cart cart = new Cart("1233", "niha123@gmail.com", list);
		when(cartRepo.save(cart)).thenReturn(cart);
		assertEquals(cart, service.addproducttocart("niha123@gmail.com", product));
	}

	@Test
	void testaddproducttocartForNotEqualCase() {
		Products product = new Products("12847hhd", "mobile", "mi", "1", "8797");
		ArrayList<Products> list = new ArrayList<>();
		list.add(product);

		when(cartRepo.findAll())
				.thenReturn(Stream.of(new Cart("1233", "niha123@gmail.com", list)).collect(Collectors.toList()));
		Cart cart = new Cart("niha1@gmail.com", list);
		when(cartRepo.save(cart)).thenReturn(cart);
		assertEquals(cart, service.addproducttocart("niha1@gmail.com", product));
		assertEquals(cart.getCartitems(), service.addproducttocart("niha1@gmail.com", product).getCartitems());
	}

	@Test
	void testgetCartByEmail() {
		Products product = new Products("12847hhd", "mobile", "mi", "1", "8797");
		ArrayList<Products> list = new ArrayList<>();
		list.add(product);
		Cart cart = new Cart("1233", "niha123@gmail.com", list);
		when(cartRepo.findAll()).thenReturn(Stream.of(cart).collect(Collectors.toList()));

		assertEquals(cart, service.getCartByEmail("niha123@gmail.com"));
	}

	@Test
	void testgetCartByEmailForNullCase() {

		Products product = new Products("12847hhd", "mobile", "mi", "1", "8797");
		ArrayList<Products> list = new ArrayList<>();
		list.add(product);
		Cart cart = new Cart("1233", "niha123@gmail.com", list);
		when(cartRepo.findAll()).thenReturn(Stream.of(cart).collect(Collectors.toList()));

		assertEquals(null, service.getCartByEmail("niha12@gmail.com"));
	}

	@Test
	void testbuyall() {
		
		Products product = new Products("12847hhd", "mobile", "mi", "1", "8797");
		ArrayList<Products> list = new ArrayList<>();
		list.add(product);
		Cart cart = new Cart("1233", "niha123@gmail.com", list);
		when(cartRepo.findAll()).thenReturn(Stream.of(cart).collect(Collectors.toList()));
		CustomerOrders order = new CustomerOrders("niha123@gmail.com", list, 123, 12, 23,"order placed");
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(order, service.buyall("niha123@gmail.com", order));

	}

	@Test
	void testbuyallForNullCase() {
		
		Products product = new Products("12847hhd", "mobile", "mi", "1", "8797");
		ArrayList<Products> list = new ArrayList<>();
		list.add(product);
		Cart cart = new Cart("1233", "niha123@gmail.com", list);
		when(cartRepo.findAll()).thenReturn(Stream.of(cart).collect(Collectors.toList()));
		CustomerOrders order = new CustomerOrders("niha123@gmail.com", list, 123, 12, 23,"order placed");
		assertEquals(null, service.buyall("niha1@gmail.com", order));

	}

	@Test
	void testbuynow() {

		Products product = new Products("12847hhd", "mobile", "mi", "1", "8797");
		ArrayList<Products> list = new ArrayList<>();
		list.add(product);
		CustomerOrders order = new CustomerOrders("niha123@gmail.com", list, 123, 12, 23,"order placed");
		when(orderRepo.save(order)).thenReturn(order);
		assertEquals(order, service.buynow("niha123@gmail.com", product, order));
	}

	@Test
	void testgetordersbuymail() {
	
		Products product = new Products("12847hhd", "mobile", "mi", "1", "8797");
		ArrayList<Products> list = new ArrayList<>();
		list.add(product);
		CustomerOrders order = new CustomerOrders("niha123@gmail.com", list, 123, 12, 23,"order placed");
		ArrayList<CustomerOrders> listoforders = new ArrayList<>();
		listoforders.add(order);
		when(orderRepo.findAll()).thenReturn(Stream.of(order).collect(Collectors.toList()));
		assertEquals(listoforders, service.getordersbuymail("niha123@gmail.com"));

	}

	@Test
	void testcancelorder() {
		String id = "45678bsdfg";

		service.cancelorder(id);
		verify(orderRepo, times(1)).deleteById(id);
	}

}
