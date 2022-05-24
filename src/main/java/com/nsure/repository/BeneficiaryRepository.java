package com.nsure.repository;

import com.nsure.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {

    List<Beneficiary> findAllByInsuranceId(String insurance_id);
}
