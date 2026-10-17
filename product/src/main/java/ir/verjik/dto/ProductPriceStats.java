package ir.verjik.dto;

public interface ProductPriceStats {
    Long getProductId();
    Long getMinPrice();
    Long getMaxPrice();
    Double getAvgPrice();
}