package com.be_casemd6.repo;

import com.be_casemd6.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepo extends PagingAndSortingRepository<Account,Integer> {

    Account findAccountByUsername(String username);
    Account findAccountByEmail(String email);
    Account findAccountByPhoneNumber(String phoneNumber);
    List<Account> findAllByFullNameContaining(String fullname);
}
