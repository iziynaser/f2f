package com.f2f.dbc.persistence.repository;

import com.f2f.dbc.persistence.entity.UserAccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
    UserAccountEntity findByUsername(String username);

    Page<UserAccountEntity> findByUsernameLike(String username, Pageable page);

    boolean existsByUsername(String username);
}
