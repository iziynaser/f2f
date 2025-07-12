package com.f2f.port;

import com.f2f.dto.ProductDTO;
import com.f2f.dto.ProductItemDTO;

// در dbc
public interface ProductItemPort {
    ProductItemDTO findById(Long id);
    ProductDTO findProductById(Long id);
}
