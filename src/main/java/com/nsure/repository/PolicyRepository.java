package com.nsure.repository;

import com.nsure.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {
    Optional<Policy> findById(Integer id);
}
