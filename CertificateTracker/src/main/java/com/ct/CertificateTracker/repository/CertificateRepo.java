package com.ct.CertificateTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ct.CertificateTracker.model.Certificate;

@Repository
public interface CertificateRepo extends MongoRepository<Certificate, String> {

}
