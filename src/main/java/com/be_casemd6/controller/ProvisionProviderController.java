package com.be_casemd6.controller;

import com.be_casemd6.model.ProvisionProvider;
import com.be_casemd6.service.IProvisionProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provisionproviders")
@CrossOrigin("*")
public class ProvisionProviderController {
    @Autowired
    IProvisionProviderService iProvisionProviderService;
    @GetMapping
    public ResponseEntity<List<ProvisionProvider>> getAllProvisionProvider() {
        return new ResponseEntity<>(iProvisionProviderService.getAllProvisionProvider(), HttpStatus.OK);
    }
}
