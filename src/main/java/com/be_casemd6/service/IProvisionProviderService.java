package com.be_casemd6.service;

import com.be_casemd6.model.ProvisionProvider;

import java.util.List;

public interface IProvisionProviderService {
    //    hien thi cac dich vu cua nha cung cap
    List<ProvisionProvider> getAllProvisionProvider();
    List<ProvisionProvider> getAllProvisionByProviderId(Integer id);

    ProvisionProvider save(ProvisionProvider provisionProvider);
    List<ProvisionProvider> findProvisionProviderByProviderId(Integer providerId);
    ProvisionProvider findById(Integer id);
    List<ProvisionProvider> findProvisionProviderByProviderIdAndStatus1(Integer id);
}
