package com.be_casemd6.service.impl;

import com.be_casemd6.model.ProvisionProvider;
import com.be_casemd6.repository.IProvisionProviderRepo;
import com.be_casemd6.service.IProvisionProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProvisionProviderServiceImpl implements IProvisionProviderService {
    @Autowired
    IProvisionProviderRepo iProvisionProviderRepo;

    @Override
    public List<ProvisionProvider> getAllProvisionProvider() {
        return (List<ProvisionProvider>) iProvisionProviderRepo.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }
}
