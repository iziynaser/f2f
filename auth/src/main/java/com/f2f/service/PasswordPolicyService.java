package com.f2f.service;

import com.f2f.persisence.PasswordPolicyEntity;
import com.f2f.repository.PasswordPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasswordPolicyService {

    @Autowired
    private PasswordPolicyRepository passwordPolicyRepository;

    public boolean validatePassword(String password) {
        Optional<PasswordPolicyEntity> policy = passwordPolicyRepository.findTopByOrderByIdDesc();

        if(password.length() < policy.get().getMinLength()) return false;
        if(policy.get().isRequireUppercase() && !password.matches(".*[A-Z].*")) return false;
        if(policy.get().isRequireLowercase() && !password.matches(".*[a-z].*")) return false;
        if(policy.get().isRequireNumber() && !password.matches(".*\\d.*")) return false;
        if(policy.get().isRequireSpecialChar() && !password.matches(".*[^a-zA-Z0-9].*")) return false;

        return true;
    }
}
