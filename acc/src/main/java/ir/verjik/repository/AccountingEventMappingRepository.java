package ir.verjik.repository;

import ir.verjik.entity.AccountingEventMapping;
import ir.verjik.enums.AccountingEventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountingEventMappingRepository
        extends JpaRepository<AccountingEventMapping, Long> {

    Optional<AccountingEventMapping> findByEventType(AccountingEventType type);

}

