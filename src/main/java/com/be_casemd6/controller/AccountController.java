package com.be_casemd6.controller;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.Provider;
import com.be_casemd6.model.dto.AccountToken;
import com.be_casemd6.repository.IAccountRepo;
import com.be_casemd6.service.IAccountService;
import com.be_casemd6.service.IProviderService;
import com.be_casemd6.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")

public class AccountController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IProviderService providerService;
    @Autowired
    JwtService jwtService;
    @PostMapping("/register")
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
    @PostMapping("/login")
    public ResponseEntity<AccountToken> login(@RequestBody Account account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtService.createToken(authentication);
        Account account1 = accountService.findAccountByUsername(account.getUsername());

        AccountToken accountToken = new AccountToken(account1.getId(), account1.getUsername(), token, account1.getRoles());
        return new ResponseEntity<>(accountToken, HttpStatus.OK);


    }
}
