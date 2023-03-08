package com.be_casemd6.service.impl;

import com.be_casemd6.model.Provider;
import com.be_casemd6.repository.IProviderRepo;
import com.be_casemd6.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProviderServiceImpl implements IProviderService {
    @Autowired
    private IProviderRepo providerRepo;
    @Override
    public Provider createProvider(Provider provider) {
        providerRepo.save(provider);
        return provider;
    }
}
