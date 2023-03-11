package com.be_casemd6.service.impl;

import com.be_casemd6.model.Provider;
import com.be_casemd6.repo.IProviderRepo;
import com.be_casemd6.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderService implements IProviderService {
    @Autowired
    IProviderRepo iProviderRepo;
    @Override
    public Provider createProvider(Provider provider) {
        iProviderRepo.save(provider);
        return provider;
    }
    @Override
    public List<Provider> getAllProviderAcc() {
        return (List<Provider>) iProviderRepo.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }
    @Override
    public List<Provider> getProviderTopView() {
        List<Provider> providers = iProviderRepo.getProviderTopView();
        List<Provider> providerList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            providerList.add(providers.get(i));
        }
        return providerList;
    }
}
