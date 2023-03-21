package com.be_casemd6.service.impl;

import com.be_casemd6.model.Account;
import com.be_casemd6.repo.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import com.be_casemd6.service.IAccountService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService, UserDetailsService {

    @Autowired
    private IAccountRepo iAccountRepo;

    @Override
    public List<Account> findAllAccounts() {
        return (List<Account>) iAccountRepo.findAll();
    }

    @Override
    public Account findAccountById(int id) {
        return iAccountRepo.findById(id).get();
    }

    @Override
    public Account save(Account account) {
        return iAccountRepo.save(account);
    }

    @Override
    public List<Account> findAllByFullNameContaining(String fullname) {
        return iAccountRepo.findAllByFullNameContaining(fullname);
    }


    @Override
    public Account findAccountByEmail(String email) {
        return iAccountRepo.findAccountByEmail(email);
    }


    @Override
    public List<Account> getAllProvider() {
        return (List<Account>) iAccountRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Account findAccountByPhoneNumber(String phoneNumber) {
        return iAccountRepo.findAccountByPhoneNumber(phoneNumber);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.findAccountByUsername(username);
        return new User(account.getUsername(), account.getPassword(), account.getRoles());
    }


    @Override
    public Account createAccount(Account account) {
        account.setStatusVip(1);
        iAccountRepo.save(account);
        return account;
    }

    @Override
    public Account findAccountByUsername(String username) {
        return iAccountRepo.findAccountByUsername(username);
    }

}
