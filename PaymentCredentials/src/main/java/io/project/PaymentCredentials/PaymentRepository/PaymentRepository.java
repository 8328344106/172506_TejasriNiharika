package io.project.PaymentCredentials.PaymentRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.project.PaymentCredentials.Payment.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String>{

}
