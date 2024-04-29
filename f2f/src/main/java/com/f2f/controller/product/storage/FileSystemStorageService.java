package com.f2f.controller.product.storage;

import com.f2f.config.StorageProperties;
import org.bouncycastle.util.StoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService{

    //private final Path rootLocation;
    private Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    @PostConstruct
    public void init() {
        try{
            Files.createDirectories(rootLocation);
        }catch (IOException e){
            throw new StorageException("could not initialize storage location",e);
        }
    }

    @Override
    public String store(MultipartFile file,String type,String productId) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(file.isEmpty())
                throw new StorageException("Failed to store empty file"+ filename);
            if(filename.contains(".."))
                throw new StorageException("can not store file with relative path outside current directory"+ filename);
            try{
                InputStream inputStream = file.getInputStream();

                Path dirPathObj = Paths.get(rootLocation.toString(),productId,type);
                boolean dirExists = Files.exists(dirPathObj);
                if(!dirExists){
                    try {
                        Files.createDirectories(dirPathObj);
                        System.out.println("! New Directory Successfully Created !");
                    } catch (IOException ioExceptionObj) {
                        System.out.println("Problem Occured While Creating The Directory Structure= " + ioExceptionObj.getMessage());
                    }
                }

                Files.copy(inputStream,dirPathObj.resolve(filename),StandardCopyOption.REPLACE_EXISTING);

            }catch (IOException ioe){
                throw new StoreException("failed to store file"+filename,ioe);
            }
        }catch (Exception e){
            throw new StoreException("failed to store file"+filename,e);
        }
        return filename;
    }

    @Override
    public Stream<Path> loadAll(String productId,String type) {
        try{
            Path dirPathObj = Paths.get(rootLocation.toString(),productId,type);
            return Files.walk(dirPathObj,1)
                    .filter(path -> !path.equals(dirPathObj))
                        //.filter(path -> !Files::isDirectory)
                        .map(dirPathObj::relativize);
        }catch (IOException ioe){
            throw new StorageException("failed to read stored files",ioe);
        }
    }

    @Override
    public Path load(String productId,String type,String fileName) {
        Path dirPathObj = Paths.get(rootLocation.toString(),productId,type);
        return dirPathObj.resolve(fileName);
        //return rootLocation.resolve(fileName);
    }

    @Override
    public Resource loadAsResource(String productId,String type,String fileName) {
        try{
                Path file = load(productId,type,fileName);
                Resource resource = new UrlResource(file.toUri());
                if(resource.exists() || resource.isReadable())
                    return resource;
                else
                    throw new FileNotFoundException("could not read file"+fileName);
        }catch (MalformedURLException e){
            throw new FileNotFoundException("could not read file "+ fileName,e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
