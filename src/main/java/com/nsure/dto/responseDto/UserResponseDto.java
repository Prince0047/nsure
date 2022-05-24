package com.nsure.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    private String id;
    private String name;
    private String email;
    private List<String> insurance;
}
