package com.nsure.service;

import com.nsure.model.Policy;
import com.nsure.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService{

    @Autowired
    PolicyRepository policyRepository;

    public List<Policy> getAllPolicy() {
        return policyRepository.findAll();
    }

    public Optional<Policy> getPolicyById(Integer id) {
        return policyRepository.findById(id);
    }

    public Policy createNewPolicy(Policy policy) {
        Policy _policy = policyRepository.save(policy);
        return _policy;
    }

    public Policy deletePolicy(Integer id) {
        Policy policy = policyRepository.getById(id);
        policyRepository.deleteById(id);

        return policy;
    }
}
