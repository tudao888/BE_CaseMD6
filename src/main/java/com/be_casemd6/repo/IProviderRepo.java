package com.be_casemd6.repo;

import com.be_casemd6.model.Provider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProviderRepo extends PagingAndSortingRepository<Provider,Integer> {
    Provider findProviderByAccount_Username(String username);
}
