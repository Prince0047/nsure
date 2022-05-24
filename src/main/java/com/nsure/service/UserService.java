package com.nsure.service;

import com.nsure.dto.responseDto.UserResponseDto;
import com.nsure.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserResponseDto> getAllUsers();
    UserResponseDto registerUser(User user);
    UserResponseDto loginUser(String email, String password);
    UserResponseDto getUser(String id);
    void deleteUser(String id);
}
