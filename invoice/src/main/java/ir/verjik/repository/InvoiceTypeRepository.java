package ir.verjik.repository;

import ir.verjik.entity.InvoiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceTypeRepository extends JpaRepository<InvoiceType, Integer> {

    // جستجو بر اساس نام نوع فاکتور
    Optional<InvoiceType> findByName(String name);

}
