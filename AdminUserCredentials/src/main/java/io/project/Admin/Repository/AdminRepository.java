package io.project.Admin.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.project.Admin.pojo.AdminPojo;


@Repository
public interface AdminRepository  extends MongoRepository<AdminPojo, String>{

}
