package com.be_casemd6.repo;

import com.be_casemd6.model.ProvisionProvider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProvisionProviderRepo extends PagingAndSortingRepository<ProvisionProvider, Integer> {
       List<ProvisionProvider> findAllByProviderId(Integer id);

}
