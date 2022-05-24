package com.nsure.repository;

import com.nsure.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    Payment findByInsuranceId(String id);
}
