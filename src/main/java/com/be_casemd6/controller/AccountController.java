package com.be_casemd6.controller;

import com.be_casemd6.model.Account;
import com.be_casemd6.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> findAllAccounts() {
        return new ResponseEntity<>(accountService.findAllAccounts(), HttpStatus.OK);
    }

    @PostMapping("/accounts/block/{id}")
    public ResponseEntity<?> blockAccount(@PathVariable int id) {
        Account account = accountService.findAccountById(id);
        if (account.getStatusAccount() == 1) {
            account.setStatusAccount(2);
        } else {
            account.setStatusAccount(1);
        }
        return new ResponseEntity<>(accountService.save(account), HttpStatus.OK);
    }

    @GetMapping("/search/{stringSearch}")
    public ResponseEntity<List<Account>> search(@PathVariable String stringSearch) {
        return new ResponseEntity<>(accountService.findAllByFullNameContaining(stringSearch), HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> search(@PathVariable int id) {
        return new ResponseEntity<>(accountService.findAccountById(id), HttpStatus.OK);
    }

    @PostMapping("/accounts/vip/{id}")
    public ResponseEntity<?> upVip(@PathVariable int id) {
        Account account = accountService.findAccountById(id);
        if (account.getStatusVip() == 1) {
            account.setStatusVip(2);
        } else {
            account.setStatusVip(1);
        }
        return new ResponseEntity<>(accountService.save(account), HttpStatus.OK);
    }
}
