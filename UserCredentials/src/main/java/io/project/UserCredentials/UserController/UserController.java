package io.project.UserCredentials.UserController;

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



import io.project.UserCredentials.UserRepository.UserRepository;
import io.project.UserCredentials.Userpojo.Userpojo;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UserController 
{
	@Autowired
	UserRepository repository;
	
	@GetMapping("/register/all")
	public List<Userpojo> getEmployees(){
		return repository.findAll();
	}
	
	@PostMapping("/register/add")
	public boolean addEmployee(@RequestBody Userpojo emp) {
		if(emp.getPassword().equals(emp.getRepeatpassword())) {
		 repository.save(emp);
		 return true;
		}
		else
			return false;
	}
	@PostMapping("/register/validate")
	public boolean validate(@RequestBody Userpojo employe) {
		List<Userpojo> log=repository.findAll();
		for(Userpojo e:log) {
			if(e.getUsername().equals(employe.getUsername())&&e.getPassword().equals(employe.getPassword()))
				return true;
		}
		return false;
	}
	@PostMapping("/register/image")
	 public Userpojo addUser(@RequestBody Userpojo pojo) {
			return repository.save(pojo);
		}

	
	@GetMapping("/register/{id}")
	public Optional<Userpojo> getEmployee(@PathVariable String id){
		return repository.findById(id);
	}
	@PutMapping("/register/{id}")
	public Userpojo UpdateEmployee(@PathVariable String id,@RequestBody Userpojo emp) {
		Optional<Userpojo> employee=repository.findById(id);
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
