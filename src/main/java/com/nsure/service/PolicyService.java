package com.nsure.service;

import com.nsure.dto.responseDto.PaymentResponseDto;
import com.nsure.model.Policy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PolicyService {

    List<Policy> getAllPolicy();
    Optional<Policy> getPolicyById(Integer id);
    Policy createNewPolicy(Policy policy);
    Policy deletePolicy(Integer id);
}
