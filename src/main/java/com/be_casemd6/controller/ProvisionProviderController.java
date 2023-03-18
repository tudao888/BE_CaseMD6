package com.be_casemd6.controller;

import com.be_casemd6.model.ProvisionProvider;
import com.be_casemd6.service.IProvisionProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provisionproviders")
@CrossOrigin("*")
public class ProvisionProviderController {
    @Autowired
    IProvisionProviderService iProvisionProviderService;
    @GetMapping()
    public ResponseEntity<List<ProvisionProvider>> getAllProvisionProvider() {
        return new ResponseEntity<>(iProvisionProviderService.getAllProvisionProvider(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<ProvisionProvider>> getAllProvisionByProviderById(@PathVariable Integer id){
        return new ResponseEntity<>(iProvisionProviderService.getAllProvisionByProviderId(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProvisionProvider> createProvisionProvider(@RequestBody ProvisionProvider provisionProvider) {
        return new ResponseEntity<>(iProvisionProviderService.save(provisionProvider), HttpStatus.OK);
    }
    @GetMapping ("/a/getStatus/{providerId}")
    public ResponseEntity<List<ProvisionProvider>> findProvisionProviderById(@PathVariable Integer providerId){
        return new ResponseEntity<>(iProvisionProviderService.findProvisionProviderByProviderId(providerId),HttpStatus.OK);
    }
    @GetMapping("/a/{id}")
    public ResponseEntity<ProvisionProvider> findById(@PathVariable Integer id){
        return new ResponseEntity<>(iProvisionProviderService.findById(id),HttpStatus.OK);
    }
    @GetMapping ("/a/getStatus1/{providerId}")
    public ResponseEntity<List<ProvisionProvider>> findProvisionProviderByProviderIdAndStatus1(@PathVariable Integer providerId){
        return new ResponseEntity<>(iProvisionProviderService.findProvisionProviderByProviderIdAndStatus1(providerId),HttpStatus.OK);
    }
}
