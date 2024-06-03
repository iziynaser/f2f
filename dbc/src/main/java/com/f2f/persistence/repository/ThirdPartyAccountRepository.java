package com.f2f.persistence.repository;

import com.f2f.persistence.entity.ThirdPartyAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThirdPartyAccountRepository extends JpaRepository<ThirdPartyAccountEntity, Long> {
    ThirdPartyAccountEntity findByThirdPartyAndThirdPartyAccountId(String thirdParty, String thirdPartyAccountId);
}
