package com.be_casemd6.controller;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.EmailDetails;

import com.be_casemd6.model.Provider;

import com.be_casemd6.model.Role;

import com.be_casemd6.service.IAccountService;
import com.be_casemd6.service.IEmailService;
import com.be_casemd6.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IProviderService iProviderService;
    @Autowired
    private IEmailService emailService;



    @PostMapping("/register")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setId(1);
        roles.add(role);
        account.setRoles(roles);
        account.setDateOfRegister(new Date().toString());
        account.setStatusAccount(1);
        account.setWallet(0.0);

        EmailDetails emailDetails = new EmailDetails(account.getEmail());
        emailService.sendSimpleMail(emailDetails, account.getUsername(), account.getPassword());
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Account>> getAllProvider() {
        return new ResponseEntity<>(iAccountService.getAllProvider(), HttpStatus.OK);
    }

    @GetMapping("/register/findAccountByUsername/{username}")
    public ResponseEntity<Account> findAccountByUsername(@PathVariable String username) {
        return new ResponseEntity<>(iAccountService.findAccountByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/register/findAccountByEmail/{email}")
    public ResponseEntity<Account> findAccountByEmail(@PathVariable String email) {
        return new ResponseEntity<>(iAccountService.findAccountByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/admin/accounts")
    public ResponseEntity<List<Account>> findAllAccounts() {
        return new ResponseEntity<>(iAccountService.findAllAccounts(), HttpStatus.OK);
    }

    @PostMapping("/admin/accounts/block/{id}")
    public ResponseEntity<?> blockAccount(@PathVariable int id) {
        Account account = iAccountService.findAccountById(id);
        if (account.getStatusAccount() == 1) {
            account.setStatusAccount(2);
        } else {
            account.setStatusAccount(1);
        }
        return new ResponseEntity<>(iAccountService.save(account), HttpStatus.OK);
    }

    @GetMapping("/admin/search/{stringSearch}")
    public ResponseEntity<List<Account>> search(@PathVariable String stringSearch) {
        return new ResponseEntity<>(iAccountService.findAllByFullNameContaining(stringSearch), HttpStatus.OK);
    }

    @GetMapping("/admin/accounts/{id}")
    public ResponseEntity<Account> search(@PathVariable int id) {
        return new ResponseEntity<>(iAccountService.findAccountById(id), HttpStatus.OK);
    }

    @PostMapping("/admin/accounts/vip/{id}")
    public ResponseEntity<?> upVip(@PathVariable int id) {
        Account account = iAccountService.findAccountById(id);
        if (account.getStatusVip() == 1||account.getStatusVip() == 3) {
            account.setStatusVip(2);
        } else {
            account.setStatusVip(1);
        }
        return new ResponseEntity<>(iAccountService.save(account), HttpStatus.OK);
    }
    @PostMapping("/user/editProfile")
    public ResponseEntity<Account> editProfileT(@RequestBody Account account){
        return new ResponseEntity<>(iAccountService.createAccount(account),HttpStatus.OK);
    }
    @GetMapping("/user/getAccount/{id}")
    public ResponseEntity<Account> getAccountT(@PathVariable int id){
        return new ResponseEntity<Account>(iAccountService.findAccountById(id),HttpStatus.OK);
    }
}
