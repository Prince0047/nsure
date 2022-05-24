package com.nsure.dto.responseDto;

import lombok.Data;

@Data
public class PaymentResponseDto {

    private String id;
    private String insurance_id;
    private Integer fee;
}
