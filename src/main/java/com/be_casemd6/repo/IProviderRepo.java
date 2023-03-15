package com.be_casemd6.repo;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.Provider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IProviderRepo extends PagingAndSortingRepository<Provider,Integer> {
    @Query(nativeQuery = true, value = "SELECT * from provider where status_provider = 1 order by id desc ")
    List<Provider> getProviders();
    @Query(nativeQuery = true, value = "SELECT * FROM provider order by view desc")
    List<Provider> getProviderTopView();

    @Query(nativeQuery = true, value = "select * from account join provider on account.id = provider.account_id where account.gender = 'Nam' order by view desc")
    List<Provider> getBoyProviderTopView();
    @Query(nativeQuery = true, value = "select * from account join provider on account.id = provider.account_id where account.gender = 'Nữ' order by view desc")
    List<Provider> getGirlProviderTopView();
    Provider findProviderByAccount_Username(String username);
}
