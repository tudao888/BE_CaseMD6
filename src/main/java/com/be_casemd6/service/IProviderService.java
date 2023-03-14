package com.be_casemd6.service;

import com.be_casemd6.model.Provider;

import org.aspectj.apache.bcel.classfile.Module;

import java.util.List;

public interface IProviderService {
    Provider createProvider (Provider provider);
    List<Provider> getAllProviderAcc();
    Provider findProviderByAccountUsername(String username);

    List<Provider> getProviderTopView();


    Provider findProviderById(Integer id);

    Provider increaseViewProviderById(Integer id);

    Provider changeStatusProvider(Integer id);
}
