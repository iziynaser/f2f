package com.f2f.controller.product.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController("StorageController")
@RequestMapping("/f2f/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    public StorageController(StorageService storageService){
        this.storageService = storageService ;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<String> listAllFiles(Model model,@RequestParam("type")String type,@RequestParam("productId") String productId){

        //sign 1
        //        model.addAttribute("files",storageService.loadAll(productId, type).map(
        //            path -> ServletUriComponentsBuilder.fromCurrentContextPath()
        //                                               .path("/download")
        //                                               .path(path.getFileName().toString())
        //                                               .toUriString())
        //            .collect(Collectors.toList()));
        //return "listFiles";

        //sign 2
//        return storageService.loadAll(productId,type).map(path-> ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/download")
//                .path(path.getFileName().toString()).toUriString())
//                .collect(Collectors.toList());

        //sign 3
//        List<String> res = storageService.loadAll(productId,type).map(path-> ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/images/product/")
//                .path(productId)
//                .path("/")
//                .path(type)
//                .path("/")
//                .path(path.getFileName().toString()).toUriString())
//                .collect(Collectors.toList());
//        return res;

        //sign 4
//        List<String> res=new ArrayList<>();
//        Stream<Path> streamPath = storageService.loadAll(productId,type);
//        streamPath.forEach(path -> res.add(path.getFileName().toString()));
//        return res;

        List<String> res = storageService.loadAll(productId,type).map(path-> ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/images/product/")
                .path(productId)
                .path("/")
                .path(type)
                .path("/")
                .path(path.getFileName().toString()).toUriString())
                .collect(Collectors.toList());
        return res;


    }

    @PostMapping("/upload-file")
    @ResponseBody
    public FileResponse uploadFile(@RequestParam("photos") MultipartFile file,String type,String productId){
            String name = storageService.store(file,type,productId);
            String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                                                    .path("/images/product/")
                                                    .path(productId)
                                                    .path("/")
                                                    .path(type)
                                                    .path("/")
                                                    .path(name)
                                                    .toUriString();
                return new FileResponse(name,uri,file.getContentType(),file.getSize());
    }

//    @PostMapping("/upload-multiple-files")
//    @ResponseBody
//    public List<FileResponse> uploadMultipleFiles(@RequestParam("photos") MultipartFile [] files){
//            return Arrays.stream(files)
//                .map(file->uploadFile(file))
//                .collect(Collectors.toList());
//    }

    @PostMapping("/upload-multiple-files")
    @ResponseBody
    public List<FileResponse> uploadMultipleFiles(@RequestParam("type")String type,@RequestParam("productId") String productId,@RequestParam("photos") MultipartFile [] files){
        //System.out.println("productId"+productId);
        //System.out.println("type"+type);
        return Arrays.stream(files)
            .map(file->uploadFile(file,type,productId))
            .collect(Collectors.toList());
    }

    public StorageService getStorageService() {
        return storageService;
    }

    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }
}
