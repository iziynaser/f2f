package com.f2f.controller.product.storage;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    String store(MultipartFile file,String type,String productId);

    Stream<Path> loadAll(String productId,String type);
    
    Path load(String productId,String type,String fileName);

    Resource loadAsResource(String productId,String type,String fileName);

    void deleteAll();
}
