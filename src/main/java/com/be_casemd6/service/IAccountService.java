package com.be_casemd6.service;

import com.be_casemd6.model.Account;

public interface IAccountService {
    Account createAccount (Account account);
    Account findAccountByUsername(String username);
<<<<<<< HEAD
    Account findAccountByEmail(String email);
=======
    List<Account> getAllProvider();


>>>>>>> a483a158f0f01bb19e349ceb3e47ba770115000c
}
