package com.f2f.service;

import com.f2f.dto.UserAccountDTO;
import com.f2f.entity.UserAccountEntity;
import com.f2f.mapper.PasswordPolicyMapper;
import com.f2f.mapper.UserAccountMapper;
import com.f2f.entity.PasswordPolicyEntity;
import com.f2f.repository.PasswordPolicyRepository;
import com.f2f.repository.RoleRepository;
import com.f2f.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserAccountRepository userAccountRepository;
    //private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final PasswordPolicyRepository passwordPolicyRepository;
    private final UserAccountMapper userAccountMapper;
    private final PasswordPolicyMapper passwordPolicyMapper;

    public UserAccountDTO createUser(UserAccountDTO dto) {
        // اعتبارسنجی پسورد با سیاست‌ها
        PasswordPolicyEntity policy = passwordPolicyRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new RuntimeException("Password policy not found"));
        if (!policy.validatePassword(dto.getPassword())) {
            throw new IllegalArgumentException("Password does not meet policy requirements");
        }

        UserAccountEntity entity = userAccountMapper.toEntity(dto);
        // توجه: رمز را باید قبل از ذخیره encode کرد
        // entity.setPassword(passwordEncoder.encode(dto.getPassword()));

        UserAccountEntity saved = userAccountRepository.save(entity);
        return userAccountMapper.toDTO(saved);
    }

    public UserAccountDTO getUserByUsername(String username) {
        return null;
//        return userAccountRepository.findByUsername(username)
//                .map(userAccountMapper::toDTO)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    // بقیه متدها مثل update, delete و تغییر رمز و ...
}
