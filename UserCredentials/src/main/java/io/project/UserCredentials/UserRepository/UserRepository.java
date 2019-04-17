package io.project.UserCredentials.UserRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.project.UserCredentials.Userpojo.Userpojo;

@Repository
public interface UserRepository extends MongoRepository<Userpojo, String>{

}
