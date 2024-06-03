package com.f2f.persistence.repository;

import com.f2f.persistence.entity.OauthClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthClientRepository extends JpaRepository<OauthClientEntity, Long> {
    OauthClientEntity findByClientId(String clientId);
}
