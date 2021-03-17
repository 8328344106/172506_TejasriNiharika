package com.ct.CertificateTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ct.CertificateTracker.model.PlannedCertification;

@Repository
public interface PlannedCerRepo extends MongoRepository<PlannedCertification, String> {

	
	   public PlannedCertification findBy_id(String _id);

}
