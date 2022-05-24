package com.nsure.controller;

import com.nsure.dto.requestDto.UserRequestDto;
import com.nsure.dto.responseDto.UserResponseDto;
import com.nsure.model.User;
import com.nsure.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600000)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {

        List<UserResponseDto> userResponseDtoList = userService.getAllUsers();
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public UserResponseDto regiterlUsers(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserResponseDto> loginUser(@RequestBody UserRequestDto userRequestDto) {

        String email = userRequestDto.getEmail();
        String password = userRequestDto.getPassword();

        UserResponseDto userResponseDto = userService.loginUser(email, password);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String id) {

        System.out.println("=============================== " + id);
        UserResponseDto userResponseDto = userService.getUser(id);


        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
