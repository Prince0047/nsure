package com.nsure.service;

import com.nsure.dto.responseDto.PaymentResponseDto;
import com.nsure.model.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {

    PaymentResponseDto getPaymentByInsurance(String insurance_id);
}
