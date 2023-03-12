package com.be_casemd6.controller;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.Role;
import com.be_casemd6.model.dto.AccountToken;
import com.be_casemd6.service.impl.AccountService;
import com.be_casemd6.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    AccountService accountService;

    @PostMapping("/login")
    public AccountToken login(@RequestBody Account account){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtService.createToken(authentication);
        Account account1 = accountService.findAccountByUsername(account.getUsername());
        AccountToken accountToken = new AccountToken(account1.getId(),account1.getUsername(),token,account1,account1.getRoles());
        return accountToken;
    }

//    @PostMapping("/register")
//    public ResponseEntity<Account> register(@RequestBody Account account) {
//        List<Role> roles = new ArrayList<>();
//        Role role = new Role();
//        role.setId(1);
//        roles.add(role);
//        account.setRoles(roles);
//        return new ResponseEntity<>(accountService.save(account), HttpStatus.OK);
//    }
}
