package com.be_casemd6.service.impl;

import com.be_casemd6.model.Account;
import com.be_casemd6.repository.IAccountRepo;
import com.be_casemd6.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AccountServiceImpl implements IAccountService {
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
}
