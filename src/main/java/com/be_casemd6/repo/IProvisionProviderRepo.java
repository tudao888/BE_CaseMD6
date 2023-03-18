package com.be_casemd6.repo;

import com.be_casemd6.model.ProvisionProvider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProvisionProviderRepo extends PagingAndSortingRepository<ProvisionProvider, Integer> {
       List<ProvisionProvider> findAllByProviderId(Integer id);
       @Query(nativeQuery = true, value = "SELECT * FROM provision_provider WHERE provision_provider.provider_id = :provider_id")
       List<ProvisionProvider> findProvisionProviderByProviderId(@Param("provider_id") int provider_id);
       @Query(nativeQuery = true, value = "SELECT * FROM provision_provider WHERE provision_provider.provider_id = :provider_id and provision_provider.status_service_provider=1")
       List<ProvisionProvider> findProvisionProviderByProviderIdAndStatus1(@Param("provider_id") int provider_id);

}
