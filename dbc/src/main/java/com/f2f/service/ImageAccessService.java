package com.f2f.service;

import java.util.Optional;

public interface ImageAccessService {
    Optional<String> getCardImageUrlForProduct(Long productId);
}
