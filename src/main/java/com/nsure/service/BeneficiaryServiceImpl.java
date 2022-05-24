package com.nsure.service;

import com.nsure.dto.mapper;
import com.nsure.dto.requestDto.BeneficiaryRequestDto;
import com.nsure.dto.responseDto.BeneficiaryResponseDto;
import com.nsure.exception.ResourceNotFoundException;
import com.nsure.model.Beneficiary;
import com.nsure.model.Insurance;
import com.nsure.repository.BeneficiaryRepository;
import com.nsure.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

    private final BeneficiaryRepository beneficiaryRepository;
    private final InsuranceRepository insuranceRepository;

    @Autowired
    public BeneficiaryServiceImpl(BeneficiaryRepository beneficiaryRepository, InsuranceRepository insuranceRepository) {
        this.beneficiaryRepository = beneficiaryRepository;
        this.insuranceRepository = insuranceRepository;
    }

    public List<BeneficiaryResponseDto> getBeneficiaryByInsurance(String insurance_id) {

        List<Beneficiary> beneficiaryList = beneficiaryRepository.findAllByInsuranceId(insurance_id);

        List<BeneficiaryResponseDto> beneficiaryResponseDtoList = new ArrayList<BeneficiaryResponseDto>();

        for (Beneficiary beneficiary: beneficiaryList
             ) {
            beneficiaryResponseDtoList.add(mapper.beneficiaryMap(beneficiary));
        }

        return beneficiaryResponseDtoList;

    }

    public List<BeneficiaryResponseDto> addNewBeneficiaryList(List<BeneficiaryRequestDto> beneficiaryRequestDtoList) {
        List<BeneficiaryResponseDto> beneficiaryResponseDtoList = new ArrayList<BeneficiaryResponseDto>();

        if(beneficiaryRequestDtoList == null) {
            throw new ResourceNotFoundException("No beneficiary is given...");
        }
        for (BeneficiaryRequestDto beneficiaryRequestDto: beneficiaryRequestDtoList
             ) {
            Beneficiary beneficiary = new Beneficiary();

            Optional<Insurance> _insurance = insuranceRepository.findById(beneficiaryRequestDto.getInsurance_id());
            beneficiary.setInsurance(_insurance.get());

            beneficiary.setName(beneficiaryRequestDto.getName());
            beneficiary.setAge(beneficiaryRequestDto.getAge());
            beneficiary.setOccupation(beneficiaryRequestDto.getOccupation());
            beneficiary.setAddress(beneficiaryRequestDto.getAddress());

            Beneficiary _beneficiary = beneficiaryRepository.save(beneficiary);

            beneficiaryResponseDtoList.add(mapper.beneficiaryMap(_beneficiary));

        }

        return beneficiaryResponseDtoList;
    }


}
