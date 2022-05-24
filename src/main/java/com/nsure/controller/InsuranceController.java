package com.nsure.controller;

import com.nsure.dto.requestDto.InsuranceRequestDto;
import com.nsure.dto.responseDto.InsuranceResponseDto;
import com.nsure.model.Insurance;
import com.nsure.service.InsuranceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    InsuranceServiceImpl insuranceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Insurance>> getAllInsurance() {
        System.out.println("here in Controller");
        List<Insurance> insurances = insuranceService.getAllInsurance();
        return new ResponseEntity<>(insurances, HttpStatus.OK);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<InsuranceResponseDto> addInsurance(@RequestBody InsuranceRequestDto insuranceRequestDto) {

        InsuranceResponseDto insuranceResponseDto = insuranceService.addNewInsurance(insuranceRequestDto);

        return new ResponseEntity<>(insuranceResponseDto, HttpStatus.OK);

    }

    @RequestMapping(value = "/my", method = RequestMethod.GET )
    public ResponseEntity<List<InsuranceResponseDto>> getInsuranceByUser(@RequestBody InsuranceRequestDto insuranceRequestDto) {
        List<InsuranceResponseDto> insuranceResponseDtoList = insuranceService.getInsuranceByUser(insuranceRequestDto.getUser_id());

        return new ResponseEntity<>(insuranceResponseDtoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/addrating", method = RequestMethod.POST)
    public ResponseEntity<InsuranceResponseDto> addRating(@RequestBody InsuranceRequestDto insuranceRequestDto) {

        InsuranceResponseDto insuranceResponseDto = insuranceService.updateRating(insuranceRequestDto);
        return new ResponseEntity<>(insuranceResponseDto, HttpStatus.OK);
    }

}
