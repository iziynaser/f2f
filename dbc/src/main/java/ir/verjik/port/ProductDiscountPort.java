package ir.verjik.port;

// ProductDiscountPort.java (دریافت اطلاعات تخفیف فعال)

import java.util.List;

public interface ProductDiscountPort {
    List<Long> getDiscountedProductIds();
}
