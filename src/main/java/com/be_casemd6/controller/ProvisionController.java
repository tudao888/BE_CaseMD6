package com.be_casemd6.controller;

import com.be_casemd6.model.Provision;
import com.be_casemd6.service.impl.ProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provisions")
@CrossOrigin("*")
public class ProvisionController {
    @Autowired
    private ProvisionService provisionService;

    @PostMapping
    public ResponseEntity<Provision> createProvision(@RequestBody Provision provision) {
        return new ResponseEntity<>(provisionService.save(provision), HttpStatus.OK);
    }

    @GetMapping("/basic")
    public ResponseEntity<List<Provision>> getAllBasicProvision() {
        return new ResponseEntity<>(provisionService.findAllBasicProvision(), HttpStatus.OK);
    }
    @GetMapping("/free")
    public ResponseEntity<List<Provision>> getAllFreeProvision() {
        return new ResponseEntity<>(provisionService.findAllFreeProvision(), HttpStatus.OK);
    }
    @GetMapping("/extend")
    public ResponseEntity<List<Provision>> getAllExtendProvision() {
        return new ResponseEntity<>(provisionService.findAllExtendProvision(), HttpStatus.OK);
    }
}
