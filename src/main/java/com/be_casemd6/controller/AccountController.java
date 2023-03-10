package com.be_casemd6.controller;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.EmailDetails;
import com.be_casemd6.service.IAccountService;
import com.be_casemd6.service.IEmailService;
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
    private IEmailService emailService;

    @PostMapping
    public ResponseEntity<Account> createAccountAndProviderDefault(@RequestBody Account account) {
        account.setDateOfRegister(new Date().toString());
        account.setStatusAccount(0);
        account.setWallet(0.0);
        account.setStatusComment(0);
        iAccountService.createAccount(account);
        Account account1 = iAccountService.findAccountByUsername(account.getUsername());
        EmailDetails emailDetails = new EmailDetails(account1.getEmail());
        emailService.sendSimpleMail(emailDetails, account1.getUsername(), account1.getPassword());
        return new ResponseEntity<>(account1, HttpStatus.OK);
    }
        @GetMapping
        public ResponseEntity<List<Account>> getAllProvider () {
            return new ResponseEntity<>(iAccountService.getAllProvider(), HttpStatus.OK);
        }
        @GetMapping("/findAccountByUsername/{username}")
        public ResponseEntity<Account> findAccountByUsername(@PathVariable String username){
            return new ResponseEntity<>(iAccountService.findAccountByUsername(username), HttpStatus.OK);
        }
        @GetMapping("/findAccountByEmail/{email}")
        public ResponseEntity<Account> findAccountByEmail(@PathVariable String email){
            return new ResponseEntity<>(iAccountService.findAccountByEmail(email), HttpStatus.OK);
        }

    }
