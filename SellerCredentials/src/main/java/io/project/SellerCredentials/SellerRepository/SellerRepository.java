package io.project.SellerCredentials.SellerRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.project.SellerCredentials.Seller.Seller;

@Repository
public interface SellerRepository extends MongoRepository<Seller, String>{

}
