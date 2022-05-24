package com.nsure.repository;

import com.nsure.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, String> {
    List<Insurance> findAllByUserId(String user_id);
}
