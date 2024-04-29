package com.f2f.controller.product;

import com.f2f.dao.product.PImageRepository;
import com.f2f.entity.product.PImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/f2f/image")
public class PImageController {

    @Qualifier("PImageRepository")
    @Autowired
    PImageRepository repository;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("imagefile")MultipartFile file)throws IOException {
        System.out.println("origininal Image byte size:"+ file.getBytes().length);
        PImage image = new PImage(file.getOriginalFilename(),file.getContentType(),file.getBytes());
        repository.save(image);
        return "ok" ;
    }

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public PImage getImage(@PathVariable(value = "name") String name)throws IOException{
        final Optional<PImage> retrieveImage = repository.findByName(name);
        PImage image = new PImage(retrieveImage.get().getName(),retrieveImage.get().getType(),retrieveImage.get().getPicByte());
        return image;
    }





}
