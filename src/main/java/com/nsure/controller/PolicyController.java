package com.nsure.controller;

import com.nsure.model.Policy;
import com.nsure.service.PolicyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600000)
@RestController
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    PolicyServiceImpl policyService;

    @RequestMapping("")
    public List<Policy> getAllPolicy() {
        return policyService.getAllPolicy();
    }

    @RequestMapping(value = "/add-policy", method = RequestMethod.POST)
    public Policy addNewPolicy(@RequestBody Policy policy) {
        return policyService.createNewPolicy(policy);
    }


}
