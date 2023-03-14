package com.be_casemd6.controller;

import com.be_casemd6.model.Provider;
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
    public ResponseEntity<List<ProvisionProvider>> getAllByUsername(@PathVariable Integer id){
        return new ResponseEntity<>(iProvisionProviderService.getAllProvisionByProviderId(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProvisionProvider> createProvisionProvider(ProvisionProvider provider) {
        return new ResponseEntity<>(iProvisionProviderService.save(provider), HttpStatus.OK);
    }

}
