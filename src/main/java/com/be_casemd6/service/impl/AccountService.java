package com.be_casemd6.service.impl;

import com.be_casemd6.model.Account;
import com.be_casemd6.repository.iAccountRepo;
import com.be_casemd6.service.iAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements iAccountService {

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
    public Object save(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public List<Account> findAllByFullNameContaining(String fullname) {
        return accountRepo.findAllByFullNameContaining(fullname);
    }
}
