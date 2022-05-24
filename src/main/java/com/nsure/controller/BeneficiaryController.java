package com.nsure.controller;

import com.nsure.dto.requestDto.BeneficiaryRequestDto;
import com.nsure.dto.responseDto.BeneficiaryResponseDto;
import com.nsure.service.BeneficiaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {

    @Autowired
    BeneficiaryServiceImpl beneficiaryService;

    @RequestMapping(value = "/{insurance_id}", method = RequestMethod.GET)
    public ResponseEntity<List<BeneficiaryResponseDto>> getBeneficiaryByInsurance(@PathVariable String insurance_id) {
        List<BeneficiaryResponseDto> beneficiaryResponseDtoList = beneficiaryService.getBeneficiaryByInsurance(insurance_id);

        return new ResponseEntity<>(beneficiaryResponseDtoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<List<BeneficiaryResponseDto>> addNewBeneficiaryList(@RequestBody List<BeneficiaryRequestDto> beneficiaryRequestDtoList) {

        List<BeneficiaryResponseDto> beneficiaryResponseDtoList = beneficiaryService.addNewBeneficiaryList(beneficiaryRequestDtoList);

        return new ResponseEntity<>(beneficiaryResponseDtoList, HttpStatus.OK);
    }
}
