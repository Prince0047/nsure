package com.nsure.service;

import com.nsure.dto.mapper;
import com.nsure.dto.requestDto.InsuranceRequestDto;
import com.nsure.dto.requestDto.PaymentRequestDto;
import com.nsure.dto.responseDto.PaymentResponseDto;
import com.nsure.exception.ResourceNotFoundException;
import com.nsure.model.Insurance;
import com.nsure.model.Payment;
import com.nsure.repository.InsuranceRepository;
import com.nsure.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    final private PaymentRepository paymentRepository;
    final private InsuranceRepository insuranceRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, InsuranceRepository insuranceRepository) {
        this.paymentRepository = paymentRepository;
        this.insuranceRepository = insuranceRepository;
    }

    public PaymentResponseDto getPaymentByInsurance(String insurance_id) {

        Payment payment = paymentRepository.findByInsuranceId(insurance_id);

        if(payment == null) {
            throw new ResourceNotFoundException("no payment found...");
        }

        return mapper.paymentMap(payment);
    }

    public PaymentResponseDto addNewPayment(PaymentRequestDto paymentRequestDto) {
        Payment payment = new Payment();

        System.out.println(payment.getId());

        payment.setFee(paymentRequestDto.getFee());

        Optional<Insurance> _insurance = insuranceRepository.findById(paymentRequestDto.getInsurance_id());
        payment.setInsurance(_insurance.get());

        Payment _payment = paymentRepository.save(payment);
        return mapper.paymentMap(_payment);
    }
}
