package com.f2f;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/images")
public class ImageService {

    @RequestMapping(value = "/download2.jpg",method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable String imgName) throws IOException {
        //MediaType contentType = jpg ? MediaType.IMAGE_JPEG : MediaType.IMAGE_PNG ;
        InputStream in = getClass().getResourceAsStream("/src/main/resources/public/images/"+imgName);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(new InputStreamResource(in));

    }
}
