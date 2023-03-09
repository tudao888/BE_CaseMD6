package com.be_casemd6.service;

import com.be_casemd6.model.Account;

public interface IAccountService {
    Account createAccount (Account account);
    Account findAccountByUsername(String username);
    List<Account> getAllProvider();


}
