package com.f2f.controller;

import com.f2f.service.DataLoaderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/load")
public class DataLoaderController {
    private final DataLoaderService dataLoaderService;

    public DataLoaderController(DataLoaderService dataLoaderService) {
        this.dataLoaderService = dataLoaderService;
    }

    @GetMapping("/load-folder/{environment}")
    public ResponseEntity<String> loadFolder(@PathVariable String environment) {
        try{
            dataLoaderService.loadSqlFolder(environment);
            return new ResponseEntity<>("Folder loaded :" + environment, HttpStatus.OK);
        }catch (IOException|SQLException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/load-file/{environment}/{fileName}")
    public ResponseEntity<String> loadFile(@PathVariable String environment, @PathVariable String fileName) {
        try{
            dataLoaderService.loadSqlFile(environment, fileName);
            return new ResponseEntity<>("File loaded :" + environment + ",filename:"+ fileName, HttpStatus.OK);
        }catch (IOException|SQLException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
