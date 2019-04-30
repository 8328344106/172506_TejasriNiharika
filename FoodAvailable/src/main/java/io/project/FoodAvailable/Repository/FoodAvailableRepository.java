package io.project.FoodAvailable.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.project.FoodAvailable.Pojo.FoodAvailablePojo;


@Repository
public interface FoodAvailableRepository extends MongoRepository<FoodAvailablePojo, String>{

}
