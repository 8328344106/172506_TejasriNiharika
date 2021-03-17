package com.ct.CertificateTracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ct.CertificateTracker.model.Trainings;


public interface TrainingRepo extends MongoRepository<Trainings, String>{

	public Trainings findBy_id(String _id);
	public List<Trainings> findByTrainingId(String trainingId);


}
