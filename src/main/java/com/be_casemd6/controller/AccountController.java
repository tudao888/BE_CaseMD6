package com.be_casemd6.controller;

import com.be_casemd6.model.Account;

import com.be_casemd6.model.EmailDetails;
import com.be_casemd6.model.Provider;
import com.be_casemd6.service.IAccountService;
import com.be_casemd6.service.IEmailService;
import com.be_casemd6.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IProviderService iProviderService;
    @Autowired
    private IEmailService emailService;

    @PostMapping
    public ResponseEntity<Account> createAccountAndProviderDefault(@RequestBody Account account) {
        account.setDateOfRegister(new Date().toString());
        account.setStatusAccount(0);
        account.setWallet(0.0);
        account.setStatusComment(0);
        iAccountService.createAccount(account);
        Account account1 = iAccountService.findAccountByUsername(account.getUsername());
        Provider provider = new Provider();
        provider.setAccount(account1);
        provider.setStatusProvider(0);
        provider.setStatusVIP(0);
        iProviderService.createProvider(provider);
        EmailDetails emailDetails = new EmailDetails(account1.getEmail());
        emailService.sendSimpleMail(emailDetails, account1.getUsername(), account1.getPassword());
        return new ResponseEntity<>(account1, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Account>> getAllProvider() {
        return new ResponseEntity<>(iAccountService.getAllProvider(), HttpStatus.OK);
    }

}
