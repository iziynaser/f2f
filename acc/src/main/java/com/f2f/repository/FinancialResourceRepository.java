package com.f2f.repository;

import com.f2f.entity.FinancialResource;
import com.f2f.enums.FinancialResourceType;
import com.f2f.enums.ResourceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialResourceRepository extends JpaRepository<FinancialResource, Long> {
    List<FinancialResource> findByType(FinancialResourceType type);

    List<FinancialResource> findByStatus(ResourceStatus status);

    List<FinancialResource> findByOwnerPersonId(Long personId);
}
