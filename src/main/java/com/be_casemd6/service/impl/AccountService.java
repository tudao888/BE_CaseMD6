package com.be_casemd6.service.impl;

import com.be_casemd6.model.Account;
import com.be_casemd6.repository.iAccountRepo;
import com.be_casemd6.service.iAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements iAccountService, UserDetailsService {

    @Autowired
    private iAccountRepo accountRepo;
    @Override
    public List<Account> findAllAccounts() {
        return (List<Account>) accountRepo.findAll();
    }

    @Override
    public Account findAccountById(int id) {
        return accountRepo.findById(id).get();
    }

    @Override
    public Account save(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public List<Account> findAllByFullNameContaining(String fullname) {
        return accountRepo.findAllByFullNameContaining(fullname);
    }

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepo.findAccountByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findAccountByUsername(username);
        return new User(account.getUsername(), account.getPassword(), account.getRoles());
    }
}
