package com.be_casemd6.service;


import com.be_casemd6.model.Account;

import java.util.List;

public interface iAccountService {
    List<Account> findAllAccounts() ;

    Account findAccountById(int id);

    Object save(Account account);

    List<Account> findAllByFullNameContaining(String fullname);

}
