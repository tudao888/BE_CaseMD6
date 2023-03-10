package com.be_casemd6.service.impl;

import com.be_casemd6.model.Account;
import com.be_casemd6.repository.IAccountRepo;
import com.be_casemd6.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AccountServiceImpl implements IAccountService, UserDetailsService {
    @Autowired
    private IAccountRepo accountRepo;
    @Override
    public Account createAccount(Account account) {
        accountRepo.save(account);
        return account;
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepo.findAccountByUsername(username);
    }

    @Override
    public List<Account> getAllAcc() {
        return (List<Account>) accountRepo.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findAccountByUsername(username);
        return new User(account.getUsername(), account.getPassword(), account.getRoles());
    }
}
