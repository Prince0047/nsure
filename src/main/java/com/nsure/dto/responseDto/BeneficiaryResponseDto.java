package com.nsure.dto.responseDto;

import com.nsure.model.Insurance;
import lombok.Data;

@Data
public class BeneficiaryResponseDto {

    private Integer id;
    private String insurance_id;
    private String name;
    private Integer age;
    private String occupation;
    private String address;
}
