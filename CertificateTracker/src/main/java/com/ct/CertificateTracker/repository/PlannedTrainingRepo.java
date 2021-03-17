package com.ct.CertificateTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ct.CertificateTracker.model.PlannedTraining;
import com.ct.CertificateTracker.model.TrainingRegistrations;

@Repository
public interface PlannedTrainingRepo extends MongoRepository<TrainingRegistrations, String> {

}
