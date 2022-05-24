package com.nsure.service;

import com.nsure.dto.mapper;
import com.nsure.dto.responseDto.UserResponseDto;
import com.nsure.exception.ResourceNotFoundException;
import com.nsure.model.User;
import com.nsure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserResponseDto> getAllUsers() {

        List<User> userList = userRepository.findAll();

        List<UserResponseDto> userResponseDtoList = new ArrayList<UserResponseDto>();

        for (User user: userList
             ) {
            userResponseDtoList.add(mapper.userMap(user));
        }

        return userResponseDtoList;
    }

    public UserResponseDto registerUser(User user) {
        User _user = userRepository.save(user);

        UserResponseDto userResponseDto = mapper.userMap(_user);
        return userResponseDto;
    }

    public UserResponseDto loginUser(String email, String password) {
        User _user = userRepository.findByEmail(email);

        if(_user != null) {
            if (Objects.equals(password, _user.getPassword())) {
                return mapper.userMap(_user);
            }
            return null;
        }
        return null;
    }

    public UserResponseDto getUser(String id) {
        Optional<User> user = userRepository.findById(id);

        if(user.get() == null) {
            throw new ResourceNotFoundException("user not found");
        }

        UserResponseDto userResponseDto = mapper.userMap(user.get());
        return userResponseDto;
    }

    public void deleteUser(String id) {
//        User _user = userRepository.findById(id);
        userRepository.deleteById(id);
    }
}
