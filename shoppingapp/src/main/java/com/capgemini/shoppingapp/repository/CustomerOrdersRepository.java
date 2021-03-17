package com.capgemini.shoppingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.shoppingapp.model.CustomerOrders;

@Repository
public interface CustomerOrdersRepository extends MongoRepository<CustomerOrders, String>
{

}
