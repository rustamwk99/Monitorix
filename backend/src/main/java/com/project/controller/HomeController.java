package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.FileInfo;
import com.project.model.MSystem;
import com.project.model.MUser;
import com.project.repository.SystemRepository;
import com.project.repository.UserRepository;
import com.project.service.ResponseMessage;
import com.project.service.StorageFileNotFoundException;
import com.project.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class HomeController {
    private SystemRepository systemRepository;
    private  UserRepository userRepository;

    private long diskSize = new File("/").getTotalSpace()/1000000000;
    private long freeSize = new File("/").getFreeSpace()/1000000000;

    @Autowired
    StorageService storageService;
    public HomeController(SystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }


    @RequestMapping("/test")
    public MSystem getHome(@RequestBody MSystem system){
        system.setName(System.getProperty("os.name"));
        system.setVersion(System.getProperty("os.version"));
        system.setArchitecture(System.getProperty("os.arch"));
        system.setTotalSpace(diskSize);
        system.setFreeSpace(freeSize);
        return system;
    }

    @PostMapping("/test/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/test/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(HomeController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }




}
