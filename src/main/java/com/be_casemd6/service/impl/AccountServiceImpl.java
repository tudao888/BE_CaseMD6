package com.be_casemd6.service.impl;

import com.be_casemd6.model.Account;
import com.be_casemd6.repository.IAccountRepo;
import com.be_casemd6.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Account findAccountByEmail(String email) {
        return accountRepo.findAccountByEmail(email);
    }
}
