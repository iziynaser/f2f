package com.f2f.repository;

import com.f2f.entity.PasswordPolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordPolicyRepository extends JpaRepository<PasswordPolicyEntity, Long> {
    Optional<PasswordPolicyEntity> findTopByOrderByIdDesc();
}

