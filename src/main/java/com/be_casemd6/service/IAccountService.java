package com.be_casemd6.service;


import com.be_casemd6.model.Account;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAccountService {
    List<Account> findAllAccounts();

    Account findAccountById(int id);

    Account findAccountByPhoneNumber(String phoneNumber);

    Object save(Account account);

    List<Account> findAllByFullNameContaining(String fullname);


    Account findAccountByUsername(String username);

    Account findAccountByEmail(String username);


    Account createAccount(Account account);

    List<Account> getAllProvider();
}
