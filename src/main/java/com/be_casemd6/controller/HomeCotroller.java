package com.be_casemd6.controller;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.Provider;
import com.be_casemd6.model.ProvisionProvider;
import com.be_casemd6.service.IAccountService;
import com.be_casemd6.service.IProviderService;
import com.be_casemd6.service.IProvisionProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class HomeCotroller {
    @Autowired
    IProvisionProviderService iProvisionProviderService;
    @Autowired
    IProviderService iProviderService;
    @Autowired
    IAccountService iAccountService;
    @GetMapping("/home")
    public ResponseEntity<List<ProvisionProvider>> getAll(){
        return new ResponseEntity<>(iProvisionProviderService.getAllProvisionProvider(), HttpStatus.OK);
    }
    @GetMapping("/getacc")
    public ResponseEntity<List<Account>> getAllAcc(){
        return new ResponseEntity<>(iAccountService.getAllAcc(), HttpStatus.OK);
    }
    @GetMapping("/getprovider")
    public ResponseEntity<List<Provider>> getAllProvider(){
        return new ResponseEntity<>(iProviderService.getAllProvider(), HttpStatus.OK);
    }
}
