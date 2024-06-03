package com.f2f.persistence.repository;

import com.f2f.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRoleName(String roleName);
}
