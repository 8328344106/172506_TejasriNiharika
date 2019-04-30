package io.project.SellerCredentials.SellerController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.project.SellerCredentials.Seller.Seller;
import io.project.SellerCredentials.SellerRepository.SellerRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SellerController {
	
	@Autowired
	SellerRepository repository;
	
	@GetMapping("/seller/all")
	public List<Seller> getEmployees(){
		return repository.findAll();
	}
	@PostMapping("/seller/add")
	 public Seller addUser(@RequestBody Seller pojo) {
			return repository.save(pojo);
	}
	

}
