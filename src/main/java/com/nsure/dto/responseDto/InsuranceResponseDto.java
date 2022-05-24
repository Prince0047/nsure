package com.nsure.dto.responseDto;

import lombok.Data;

import java.util.Date;

@Data
public class InsuranceResponseDto {
    private String id;
    private String userName;
    private String policyName;
    private Date activationDate;
    private Integer rating;
}
