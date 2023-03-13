package com.be_casemd6.service.impl;

import com.be_casemd6.model.Provider;
import com.be_casemd6.repo.IProviderRepo;
import com.be_casemd6.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService implements IProviderService {
    @Autowired
    IProviderRepo iProviderRepo;

    @Override
    public Provider createProvider(Provider provider) {
        return null;
    }

    @Override
    public List<Provider> getAllProviderAcc() {
        return (List<Provider>) iProviderRepo.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @Override
    public Provider findProviderByAccountUsername(String username) {
        return iProviderRepo.findProviderByAccount_Username(username);
    }
}
