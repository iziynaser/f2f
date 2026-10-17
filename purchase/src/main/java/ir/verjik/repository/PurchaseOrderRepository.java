package ir.verjik.repository;

import ir.verjik.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    public boolean existsByOrderNumber(String orderNumber);
}
