package com.f2f.controller.product.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.stream.Collectors;

@RestController("ImageController")
@RequestMapping("/images/product/")
public class ImageController {

    @Autowired
    private StorageService storageService;

    public ImageController(StorageService storageService){
        this.storageService = storageService ;
    }

    @GetMapping("/list")
    public String listAllFiles(Model model,@RequestParam("type")String type,@RequestParam("productId") String productId){
        model.addAttribute("files",storageService.loadAll(productId, type).map(
            path -> ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download")
                .path(path.getFileName().toString())
                .toUriString())
            .collect(Collectors.toList()));
        return "listFiles";
    }

    @GetMapping("/{productId}/{type}/{fileName}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String productId,
                                                 @PathVariable String type,
                                                 @PathVariable String fileName){

        Resource resource = storageService.loadAsResource(productId,type,fileName);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;filename=\""+resource.getFilename()+"\"")
            .body(resource);
    }

    public StorageService getStorageService() {
        return storageService;
    }

    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }
}
