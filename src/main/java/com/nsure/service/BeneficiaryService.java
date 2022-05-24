package com.nsure.service;

import com.nsure.dto.requestDto.BeneficiaryRequestDto;
import com.nsure.dto.responseDto.BeneficiaryResponseDto;
import com.nsure.model.Beneficiary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BeneficiaryService {

    List<BeneficiaryResponseDto> getBeneficiaryByInsurance(String insurance_id);

    List<BeneficiaryResponseDto> addNewBeneficiaryList(List<BeneficiaryRequestDto> beneficiaryRequestDtoList);
}
