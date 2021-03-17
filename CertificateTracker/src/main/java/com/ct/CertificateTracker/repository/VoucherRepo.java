package com.ct.CertificateTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ct.CertificateTracker.model.voucher;

@Repository
public interface VoucherRepo extends MongoRepository<voucher, String> {

}
