package com.be_casemd6.controller;

import com.be_casemd6.model.Image;
import com.be_casemd6.repo.IImageRepo;
import com.be_casemd6.service.IImageService;
import com.be_casemd6.service.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("image")
public class ImageController {
    @Autowired
    private ImageService imageService;
    @PostMapping
    public ResponseEntity<Image> save(@RequestBody Image image ){
        return new ResponseEntity<>(imageService.save(image), HttpStatus.OK);
    }
    @GetMapping("/a/1/{accountId}")
    public ResponseEntity<List<Image>> findByAccount_IdAAndStatusImg1(@PathVariable Integer accountId){
        return  new ResponseEntity<List<Image>>(imageService.findByAccount_IdAAndStatusImg1(accountId),HttpStatus.OK);
    }
    @GetMapping("/a/2/{accountId}")
    public ResponseEntity<List<Image>>  findByAccount_IdAAndStatusImg2(@PathVariable Integer accountId){
        return  new ResponseEntity<List<Image>>(imageService.findByAccount_IdAAndStatusImg2(accountId),HttpStatus.OK);
    }

}
