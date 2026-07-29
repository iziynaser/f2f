package com.f2f.adapter;


import com.f2f.port.ImageAccessPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.*;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ImageAccessAdapter implements ImageAccessPort {

    private final Path uploadDir;

    public ImageAccessAdapter(@Value("${public.image.dir}") String uploadDir) {
        this.uploadDir = Paths.get(uploadDir).toAbsolutePath().normalize();
    }

    @Override
    public Optional<String> getCardImageUrlForProduct(Long productId) {
        Path folder = uploadDir.resolve(productId.toString()).resolve("stf").resolve("card");
        try (Stream<Path> stream = Files.list(folder)) {
            return stream.filter(Files::isRegularFile)
                    .map(p -> "/images/" + productId + "/stf/card/" + p.getFileName().toString())
                    .findFirst();
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
