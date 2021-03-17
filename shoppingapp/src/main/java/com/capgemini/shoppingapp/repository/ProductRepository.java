package com.capgemini.shoppingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.shoppingapp.model.Products;

@Repository
public interface ProductRepository extends MongoRepository<Products, String>
{

}
