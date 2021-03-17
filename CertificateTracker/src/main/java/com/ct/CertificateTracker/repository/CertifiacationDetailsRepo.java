package com.ct.CertificateTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ct.CertificateTracker.model.CoreCertificationDetails;


@Repository
public interface CertifiacationDetailsRepo extends MongoRepository<CoreCertificationDetails, String>{

}
