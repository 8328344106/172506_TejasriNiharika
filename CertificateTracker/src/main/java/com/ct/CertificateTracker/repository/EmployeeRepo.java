package com.ct.CertificateTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ct.CertificateTracker.model.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, Integer> {

}
