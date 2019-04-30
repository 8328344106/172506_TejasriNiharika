package io.project.FoodAvailable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.project.FoodAvailable.Pojo.FoodAvailablePojo;
import io.project.FoodAvailable.Repository.FoodAvailableRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FoodAvailableController {

	@Autowired
	FoodAvailableRepository repository;
	
	@GetMapping("/food/all")
	public List<FoodAvailablePojo> getEmployees(){
		return repository.findAll();
	}
	@PostMapping("/food/add")
	 public FoodAvailablePojo addUser(@RequestBody FoodAvailablePojo pojo) {
			return repository.save(pojo);
	}
	@DeleteMapping("/food/{id}")
	public void deleteuser(@PathVariable("id") String id) {
		
				
			 repository.deleteById(id);
		
	}

}
