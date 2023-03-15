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
    @Query(nativeQuery = true, value = "SELECT * FROM provider order by view desc")
    List<Provider> getProviderTopView();


    @Query(nativeQuery = true,value = "select * from provider left join account on account_id = account.id where username=:username")
    Provider findProviderByAccountUsername(@Param("username") String username);
}
