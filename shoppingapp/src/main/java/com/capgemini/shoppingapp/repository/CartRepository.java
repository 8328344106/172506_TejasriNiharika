package com.capgemini.shoppingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.shoppingapp.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String>
{
	
}
