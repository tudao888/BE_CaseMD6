package com.be_casemd6.service;

import com.be_casemd6.model.Provider;

import org.aspectj.apache.bcel.classfile.Module;

import java.util.List;

public interface IProviderService {
    Provider createProvider (Provider provider);
    List<Provider> getAllProviderAcc();
    Provider findProviderByAccountUsername(String username);

    List<Provider> getProviderTopView();


    List<Provider> getBoyProviderTopView();

    List<Provider> getGirlProviderTopView();

    Provider findProviderById(Integer id);

    Provider increaseViewProviderById(Integer id);

    Provider changeStatusProvider(Integer id);

    Provider save(Provider provider);
    Provider findProviderByAccount_Id(Integer accountId);
}
