package ir.verjik.repository;

import ir.verjik.entity.AccountResourceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountResourceTypeRepository  extends JpaRepository<AccountResourceType, Long> {
}
