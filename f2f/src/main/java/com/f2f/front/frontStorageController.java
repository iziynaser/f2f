package com.f2f.front;

import com.f2f.controller.product.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController("frontStorageController")
@RequestMapping("/front/storage")
public class frontStorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/list")
    @ResponseBody
    public List<String> listAllFiles(Model model, @RequestParam("type")String type, @RequestParam("productId") String productId){

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

}
