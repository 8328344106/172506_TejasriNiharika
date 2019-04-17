package io.project.PaymentCredentials.PaymentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.project.PaymentCredentials.Payment.Payment;
import io.project.PaymentCredentials.PaymentRepository.PaymentRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
	
	
	@Autowired
	PaymentRepository repository;
	
	
	@GetMapping("/payment/all")
	public List<Payment> getEmployees(){
		return repository.findAll();
	}
	@PostMapping("/payment/add")
	 public Payment addUser(@RequestBody Payment pojo) {
			return repository.save(pojo);
	}


}
