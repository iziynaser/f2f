package com.f2f.repository;

import com.f2f.entity.AccountingEventMapping;
import com.f2f.enums.AccountingEventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountingEventMappingRepository
        extends JpaRepository<AccountingEventMapping, Long> {

    Optional<AccountingEventMapping> findByEventType(AccountingEventType type);

}

