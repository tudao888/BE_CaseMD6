package com.be_casemd6.repo;

import com.be_casemd6.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAccountRepo extends PagingAndSortingRepository<Account,Integer> {
}
