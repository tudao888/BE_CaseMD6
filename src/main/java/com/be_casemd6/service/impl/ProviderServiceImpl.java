package com.be_casemd6.service.impl;

import com.be_casemd6.model.Provider;
import com.be_casemd6.repository.IProviderRepo;
import com.be_casemd6.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProviderServiceImpl implements IProviderService {
    @Autowired
    private IProviderRepo providerRepo;
    @Override
    public Provider createProvider(Provider provider) {
        providerRepo.save(provider);
        return provider;
    }

    @Override
    public List<Provider> getAllProvider() {
        return (List<Provider>) providerRepo.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }
}
