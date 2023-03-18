package com.be_casemd6.service.impl;

import com.be_casemd6.model.ProvisionProvider;
import com.be_casemd6.repo.IProvisionProviderRepo;
import com.be_casemd6.service.IProvisionProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
 public class ProvisionProviderService implements IProvisionProviderService {
    @Autowired
    IProvisionProviderRepo iProvisionProviderRepo;

//    hien thi cac dich vu cua nha cung cap
    @Override
    public List<ProvisionProvider> getAllProvisionProvider() {
        return (List<ProvisionProvider>) iProvisionProviderRepo.findAll();
    }

    @Override
    public List<ProvisionProvider> getAllProvisionByProviderId(Integer id) {
        return iProvisionProviderRepo.findAllByProviderId(id);
    }

    @Override
    public ProvisionProvider save(ProvisionProvider provisionProvider) {
        return iProvisionProviderRepo.save(provisionProvider);
    }

    @Override
    public List<ProvisionProvider> findProvisionProviderByProviderId(Integer providerId) {
        return iProvisionProviderRepo.findProvisionProviderByProviderId(providerId);
    }

    @Override
    public ProvisionProvider findById(Integer id) {
        return iProvisionProviderRepo.findById(id).get();
    }

    @Override
    public List<ProvisionProvider> findProvisionProviderByProviderIdAndStatus1(Integer id) {
        return iProvisionProviderRepo.findProvisionProviderByProviderIdAndStatus1(id);
    }

}
