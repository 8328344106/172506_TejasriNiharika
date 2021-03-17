package com.ct.CertificateTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ct.CertificateTracker.model.Admin;

@Repository
public interface AdminRepo extends MongoRepository<Admin, Integer>{

}
