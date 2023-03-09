package com.be_casemd6.repository;

import com.be_casemd6.model.Provider;
import com.be_casemd6.model.ProvisionProvider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IProvisionProviderRepo extends PagingAndSortingRepository<ProvisionProvider,Integer> {
//    @Query(nativeQuery = true,value = "SELECT * from account LEFT join provider on account.id = account_id LEFT JOIN provision_provider on provider.id = provider_id LEFT join provision on provision.id = provision_id")
//    List<ProvisionProvider> showAll();
}
