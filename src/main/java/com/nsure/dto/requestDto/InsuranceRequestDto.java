package com.nsure.dto.requestDto;

import lombok.Data;

@Data
public class InsuranceRequestDto {
    private String insurance_id;
    private String user_id;
    private Integer policy_id;
    private Integer rating;
}
