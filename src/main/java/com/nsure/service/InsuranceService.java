package com.nsure.service;

import com.nsure.dto.requestDto.InsuranceRequestDto;
import com.nsure.dto.responseDto.InsuranceResponseDto;
import com.nsure.model.Insurance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InsuranceService {

    List<Insurance> getAllInsurance();
    InsuranceResponseDto addNewInsurance(InsuranceRequestDto insuranceRequestDto);
    List<InsuranceResponseDto> getInsuranceByUser(String user_id);
    InsuranceResponseDto updateRating(InsuranceRequestDto insuranceRequestDto);
}
