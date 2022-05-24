package com.nsure.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class MainController {

    @GetMapping("")
    public String showHomePage() {
        return "index";
    }


}
