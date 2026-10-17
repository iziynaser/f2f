package ir.verjik.controller;

import ir.verjik.entity.ProductImage;
import ir.verjik.repository.PImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/image")
public class PImageController {

    @Qualifier("PImageRepository")
    @Autowired
    PImageRepository repository;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("imagefile")MultipartFile file)throws IOException {
        System.out.println("origininal Image byte size:"+ file.getBytes().length);
        ProductImage image = new ProductImage(file.getOriginalFilename(),file.getContentType(),file.getBytes());
        repository.save(image);
        return "ok" ;
    }

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public ProductImage getImage(@PathVariable(value = "name") String name)throws IOException{
        final Optional<ProductImage> retrieveImage = repository.findByName(name);
        ProductImage image = new ProductImage(retrieveImage.get().getName(),retrieveImage.get().getType(),retrieveImage.get().getPicByte());
        return image;
    }





}
