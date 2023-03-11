package com.be_casemd6.repo;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.Provider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IProviderRepo extends PagingAndSortingRepository<Provider,Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM provider order by view desc")
    List<Provider> getProviderTopView();
}
