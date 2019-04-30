package io.project.Seller.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.project.Seller.Pojo.SellerPojo;
import io.project.Seller.Repository.SellerRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SellerController {
	@Autowired
	SellerRepository repository;
	
	@GetMapping("/register/all")
	public List<SellerPojo> getEmployees(){
		return repository.findAll();
	}
	
	@PostMapping("/register/add")
	public boolean addEmployee(@RequestBody SellerPojo emp) {
		if(emp.getPassword().equals(emp.getRepeatpassword())) {
		 repository.save(emp);
		 return true;
		}
		else
			return false;
	}
	@PostMapping("/register/validate")
	public boolean validate(@RequestBody SellerPojo employe) {
		List<SellerPojo> log=repository.findAll();
		for(SellerPojo e:log) {
			if(e.getUsername().equals(employe.getUsername())&&e.getPassword().equals(employe.getPassword()))
				return true;
		}
		return false;
	}
	@PostMapping("/register/image")
	 public SellerPojo addUser(@RequestBody SellerPojo pojo) {
			return repository.save(pojo);
		}

	
	@GetMapping("/register/{id}")
	public Optional<SellerPojo> getEmployee(@PathVariable String id){
		return repository.findById(id);
	}
	@PutMapping("/register/{id}")
	public SellerPojo UpdateEmployee(@PathVariable String id,@RequestBody SellerPojo emp) {
		Optional<SellerPojo> employee=repository.findById(id);
		if(employee.isPresent())
			return repository.save(emp);
		else
			return null;
	}

	@DeleteMapping("/register/{id}")
	public boolean deleteuser(@PathVariable("id") String id) {
				
			 repository.deleteById(id);
			 return true;
		
	}
	@DeleteMapping("/register/delete")
	public void deleteAll() {
		repository.deleteAll();
	}


}
