package com.nsure.service;

import com.nsure.dto.mapper;
import com.nsure.dto.requestDto.InsuranceRequestDto;
import com.nsure.dto.responseDto.InsuranceResponseDto;
import com.nsure.exception.ResourceNotFoundException;
import com.nsure.model.Insurance;
import com.nsure.model.Policy;
import com.nsure.model.User;
import com.nsure.repository.InsuranceRepository;
import com.nsure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InsuranceServiceImpl implements InsuranceService{

    private final InsuranceRepository insuranceRepository;
    private final UserServiceImpl userService;
    private final PolicyServiceImpl policyService;
    private final UserRepository userRepository;

    @Autowired
    public InsuranceServiceImpl(InsuranceRepository insuranceRepository, UserServiceImpl userService, PolicyServiceImpl policyService, UserRepository userRepository) {
        this.insuranceRepository = insuranceRepository;
        this.userService = userService;
        this.policyService = policyService;
        this.userRepository = userRepository;
    }

    public List<Insurance> getAllInsurance() {
        System.out.println("here in Service");
        List<Insurance> insurances = StreamSupport
                .stream(insuranceRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return insurances;
    }

    public InsuranceResponseDto addNewInsurance(InsuranceRequestDto insuranceRequestDto) {

        Insurance insurance = new Insurance();

        if(insuranceRequestDto.getUser_id() == null) {
            throw new ResourceNotFoundException("no user with given id");
        }

        Optional<Policy> _policy = policyService.getPolicyById(insuranceRequestDto.getPolicy_id());
        Policy policy = _policy.get();

        Optional<User> _user = userRepository.findById(insuranceRequestDto.getUser_id());
        User user = _user.get();

        insurance.setUser(user);
        insurance.setPolicy(policy);

        Insurance _insurance = insuranceRepository.save(insurance);

        return mapper.insuranceMap(_insurance);

    }

    public List<InsuranceResponseDto> getInsuranceByUser(String user_id) {
        List<Insurance> insuranceList = insuranceRepository.findAllByUserId(user_id);
        List<InsuranceResponseDto> insuranceResponseDtoList = new ArrayList<InsuranceResponseDto>();
        for (Insurance insurance: insuranceList
             ) {
            insuranceResponseDtoList.add(mapper.insuranceMap(insurance));
        }
        return insuranceResponseDtoList;
    }

    public InsuranceResponseDto updateRating(InsuranceRequestDto insuranceRequestDto) {
        Insurance insurance = insuranceRepository.getById(insuranceRequestDto.getInsurance_id());

        insurance.setRating(insuranceRequestDto.getRating());

        Insurance _insurance = insuranceRepository.save(insurance);

        return mapper.insuranceMap(_insurance);
    }

}
