package com.be_casemd6.controller;

import com.be_casemd6.model.Account;
import com.be_casemd6.service.IAccountService;
import com.be_casemd6.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin("*")
public class AccountController {
    @Autowired
    IAccountService iAccountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllProvider() {
        return new ResponseEntity<>(iAccountService.getAllProvider(), HttpStatus.OK);
    }
}
