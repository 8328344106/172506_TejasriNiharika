package com.ct.CertificateTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ct.CertificateTracker.model.InternalTest;

@Repository
public interface InternalTestRepo extends MongoRepository<InternalTest, String>{



}
