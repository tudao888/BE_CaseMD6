package com.be_casemd6.service;

import com.be_casemd6.model.Provider;

import org.aspectj.apache.bcel.classfile.Module;

import java.util.List;

public interface IProviderService {
    Provider createProvider (Provider provider);
    List<Provider> getAllProviderAcc();

    List<Provider> getProviderTopView();

    Provider findProviderById(Integer id);
}
