package com.f2f.service;

import com.f2f.dto.PriceHistoryDTO;
import com.f2f.entity.ProductItem;
import com.f2f.entity.ProductPrice;
import com.f2f.repository.ProductItemRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductPriceHistoryService {

    private final ProductItemRepository productItemRepository;

    public ProductPriceHistoryService(ProductItemRepository productItemRepository) {
        this.productItemRepository = productItemRepository;
    }

    public List<PriceHistoryDTO> getPriceHistoryForProductItem(Long productItemId) {
        ProductItem productItem = productItemRepository.findById(productItemId)
                .orElseThrow(() -> new RuntimeException("Product item not found"));

        List<PriceHistoryDTO> priceHistory = new ArrayList<>();

        List<ProductPrice> prices = new ArrayList<>();//productItem.getProductPrices();
//        if(prices != null && !prices.isEmpty()) {
//            for(ProductPrice price : prices) {
//                PriceHistoryDTO dto = new PriceHistoryDTO();
//                dto.setFromDate(price.getFromDate());
//                dto.setToDate(price.getToDate());
//                dto.setCurrency(price.getCurrency());
//                dto.setPriceTypeName(price.getProductPriceType()!= null ? price.getProductPriceType().getName() : "");
//
//                try{
//                    dto.setPrice(Long.valueOf(price.getValue()));
//                }catch(NumberFormatException e){
//                    dto.setPrice(Long.valueOf(0));
//                }
//                priceHistory.add(dto);
//            }
//        }
        return priceHistory;
    }

}
