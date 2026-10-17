package ir.verjik.port;

// ProductInventoryPort.java (دریافت اطلاعات موجودی)

public interface ProductInventoryPort {
    boolean isProductAvailable(Long productId);
}
