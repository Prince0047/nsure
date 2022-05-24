package com.nsure.controller;

import com.nsure.dto.requestDto.PaymentRequestDto;
import com.nsure.dto.responseDto.PaymentResponseDto;
import com.nsure.service.PaymentService;
import com.nsure.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600000)
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentServiceImpl paymentService;

    @RequestMapping(value = "/{insurance_id}", method = RequestMethod.GET)
    public ResponseEntity<PaymentResponseDto> getPaymentByInsurance(@PathVariable String insurance_id) {

        PaymentResponseDto paymentResponseDto = paymentService.getPaymentByInsurance(insurance_id);

        return new ResponseEntity<>(paymentResponseDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<PaymentResponseDto> addNewPayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        PaymentResponseDto paymentResponseDto = paymentService.addNewPayment(paymentRequestDto);

        return new ResponseEntity<>(paymentResponseDto, HttpStatus.OK);
    }

}
