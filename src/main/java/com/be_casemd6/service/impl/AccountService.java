package com.be_casemd6.service.impl;

import com.be_casemd6.model.Account;
import com.be_casemd6.repo.IAccountRepo;
import com.be_casemd6.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepo iAccountRepo;

    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public Account findAccountByUsername(String username) {
        return iAccountRepo.findAccountByUsername(username);
    }

    @Override
    public Account findAccountByEmail(String email) {
        return iAccountRepo.findAccountByEmail(email);
    }

    @Override
    public List<Account> getAllProvider() {
        return (List<Account>) iAccountRepo.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }
}
