package com.be_casemd6.repo;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.Provider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProviderRepo extends PagingAndSortingRepository<Provider,Integer> {
    @Query(nativeQuery = true, value = "SELECT * from provider where status_provider = 1 order by id desc ")
    List<Provider> getProviders();
    @Query(nativeQuery = true, value = "SELECT * FROM provider where status_provider = 1 order by view desc")
    List<Provider> getProviderTopView();

    @Query(nativeQuery = true, value = "select provider.* from account join provider on account.id = provider.account_id where account.gender = 'Male' and status_provider = 1 order by view desc")
    List<Provider> getBoyProviderTopView();
    @Query(nativeQuery = true, value = "select provider.* from account join provider on account.id = provider.account_id where account.gender = 'Female' and status_provider = 1 order by view desc")
    List<Provider> getGirlProviderTopView();
    @Query(nativeQuery = true, value = "SELECT * FROM provider where status_provider = 1 order by id desc limit 12")
    List<Provider> get12NewProvider();
    Provider findProviderByAccount_Username(String username);
    Provider findProviderByAccount_Id(Integer accountId);

    @Query(nativeQuery = true, value = "SELECT * FROM provider JOIN account ON provider.account_id = account.id WHERE account.full_name LIKE concat('%',:stringSearch,'%') AND account.status_account != 2 AND provider.status_provider !=2")
    List<Provider> findProvidersByAccount_FullNameContaining(@Param("stringSearch") String stringSearch);
}
