package com.nsure.dto;

import com.nsure.dto.requestDto.InsuranceRequestDto;
import com.nsure.dto.responseDto.BeneficiaryResponseDto;
import com.nsure.dto.responseDto.InsuranceResponseDto;
import com.nsure.dto.responseDto.PaymentResponseDto;
import com.nsure.dto.responseDto.UserResponseDto;
import com.nsure.model.Beneficiary;
import com.nsure.model.Insurance;
import com.nsure.model.Payment;
import com.nsure.model.User;

import java.util.ArrayList;
import java.util.List;

public class mapper {

    public static InsuranceResponseDto insuranceMap(Insurance insurance) {
        InsuranceResponseDto insuranceResponseDto = new InsuranceResponseDto();

        insuranceResponseDto.setId(insurance.getId());
        insuranceResponseDto.setPolicyName(insurance.getPolicy().getName());

        String userName = insurance.getUser().getFirstName() + " " + insurance.getUser().getLastName();
        insuranceResponseDto.setUserName(userName);

        insuranceResponseDto.setActivationDate(insurance.getActivationDate());

        if(insurance.getRating() == null) {
            insuranceResponseDto.setRating(-1);
        } else{
            insuranceResponseDto.setRating(insurance.getRating());
        }

        return insuranceResponseDto;
    }

    public static UserResponseDto userMap(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getFirstName() + " " + user.getLastName());
        userResponseDto.setEmail(user.getEmail());

        List<String> insuranceList = new ArrayList<String>();

        if(user.getInsuranceList() == null) {
            return userResponseDto;
        }
        for (Insurance insurance: user.getInsuranceList()
             ) {
            insuranceList.add(insurance.getPolicy().getName());
        }

        userResponseDto.setInsurance(insuranceList);

        return userResponseDto;
    }

    public static PaymentResponseDto paymentMap(Payment payment) {

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();

        paymentResponseDto.setId(payment.getId());
        paymentResponseDto.setFee(payment.getFee());
        paymentResponseDto.setInsurance_id((payment.getInsurance().getId()));

        return paymentResponseDto;
    }

    public static BeneficiaryResponseDto beneficiaryMap(Beneficiary beneficiary) {
        BeneficiaryResponseDto beneficiaryResponseDto = new BeneficiaryResponseDto();

        beneficiaryResponseDto.setId(beneficiary.getId());
        beneficiaryResponseDto.setInsurance_id(beneficiary.getInsurance().getId());
        beneficiaryResponseDto.setName(beneficiary.getName());
        beneficiaryResponseDto.setAge(beneficiary.getAge());
        beneficiaryResponseDto.setOccupation(beneficiary.getOccupation());
        beneficiaryResponseDto.setAddress(beneficiary.getAddress());

        return beneficiaryResponseDto;


    }
}
