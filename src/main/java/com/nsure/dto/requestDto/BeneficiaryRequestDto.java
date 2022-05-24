package com.nsure.dto.requestDto;

import lombok.Data;

@Data
public class BeneficiaryRequestDto {

    private String insurance_id;
    private String name;
    private Integer age;
    private String occupation;
    private String address;

}

