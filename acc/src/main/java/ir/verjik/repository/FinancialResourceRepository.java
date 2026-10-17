package ir.verjik.repository;

import ir.verjik.entity.FinancialResource;
import ir.verjik.enums.FinancialResourceType;
import ir.verjik.enums.ResourceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialResourceRepository extends JpaRepository<FinancialResource, Long> {
    List<FinancialResource> findByType(FinancialResourceType type);

    List<FinancialResource> findByStatus(ResourceStatus status);

    List<FinancialResource> findByOwnerPersonId(Long personId);
}
