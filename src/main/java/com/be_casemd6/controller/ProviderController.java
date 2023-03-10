package com.be_casemd6.controller;

import com.be_casemd6.model.Provider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("provider")
public class ProviderController {
    @GetMapping("/register")
    public ResponseEntity<Provider> registerProvider() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
