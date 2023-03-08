package com.be_casemd6.controller;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.Provider;
import com.be_casemd6.repository.IAccountRepo;
import com.be_casemd6.service.IAccountService;
import com.be_casemd6.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IProviderService providerService;
    @PostMapping
    public ResponseEntity<Account> createAccountAndProviderDefault(@RequestBody Account account){
        account.setDateOfRegister(new Date().toString());
        account.setStatusAccount(0);
        account.setWallet(0.0);
        account.setStatusComment(0);
        accountService.createAccount(account);
        Account account1=accountService.findAccountByUsername(account.getUsername());
        Provider provider= new Provider();
        provider.setAccount(account1);
        provider.setStatusProvider(0);
        provider.setStatusVIP(0);
        providerService.createProvider(provider);
        return new ResponseEntity<>(account1, HttpStatus.OK);
    }
}
