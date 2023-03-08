package com.be_casemd6.repository;

import com.be_casemd6.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iAccountRepo extends PagingAndSortingRepository<Account, Integer> {
    List<Account> findAllByFullNameContaining(String fullname);
}
