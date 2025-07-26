package com.f2f.port;

import java.util.Optional;

public interface ImageAccessPort {
    Optional<String> getCardImageUrlForProduct(Long productId);
}
