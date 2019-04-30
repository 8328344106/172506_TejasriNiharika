package io.project.Admin.controller;

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

import io.project.Admin.Repository.AdminRepository;
import io.project.Admin.pojo.AdminPojo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	AdminRepository repository;
	
	@GetMapping("/register/all")
	public List<AdminPojo> getEmployees(){
		return repository.findAll();
	}
	
	@PostMapping("/register/add")
	public boolean addEmployee(@RequestBody AdminPojo emp) {
		if(emp.getPassword().equals(emp.getRepeatpassword())) {
		 repository.save(emp);
		 return true;
		}
		else
			return false;
	}
	@PostMapping("/register/validate")
	public boolean validate(@RequestBody AdminPojo employe) {
		List<AdminPojo> log=repository.findAll();
		for(AdminPojo e:log) {
			if(e.getUsername().equals(employe.getUsername())&&e.getPassword().equals(employe.getPassword()))
				return true;
		}
		return false;
	}
	@PostMapping("/register/image")
	 public AdminPojo addUser(@RequestBody AdminPojo pojo) {
			return repository.save(pojo);
		}

	
	@GetMapping("/register/{id}")
	public Optional<AdminPojo> getEmployee(@PathVariable String id){
		return repository.findById(id);
	}
	@PutMapping("/register/{id}")
	public AdminPojo UpdateEmployee(@PathVariable String id,@RequestBody AdminPojo emp) {
		Optional<AdminPojo> employee=repository.findById(id);
		if(employee.isPresent())
			return repository.save(emp);
		else
			return null;
	}
	@DeleteMapping("/register")
	public void deleteEmployee(@PathVariable AdminPojo id) {
		repository.delete(id);
	}
	@DeleteMapping("/register/delete")
	public void deleteAll() {
		repository.deleteAll();
	}


}
