package com.be_casemd6.service.impl;

import com.be_casemd6.model.Provider;
import com.be_casemd6.repo.IProviderRepo;
import com.be_casemd6.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return iProviderRepo.getProviders();
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
    @Override
    public List<Provider> getBoyProviderTopView() {
        List<Provider> providers = iProviderRepo.getBoyProviderTopView();
        List<Provider> providerList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            providerList.add(providers.get(i));
        }
        return providerList;
    }
    @Override
    public List<Provider> getGirlProviderTopView() {
        List<Provider> providers = iProviderRepo.getGirlProviderTopView();
        List<Provider> providerList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            providerList.add(providers.get(i));
        }
        return providerList;
    }
//    hàm tìm ncc theo id, mỗi lần tìm thấy là tăng view lên
//    (hàm xem thông tin chi tiết và tăng view theo số lần click)
    @Override
    public Provider findProviderById(Integer id) {
       return iProviderRepo.findById(id).get();
    }
    @Override
    public Provider increaseViewProviderById(Integer id) {
        Provider provider = iProviderRepo.findById(id).get();
        provider.setView(provider.getView()+1);
        iProviderRepo.save(provider);
        return provider;
    }
    @Override
    public Provider changeStatusProvider(Integer id) {
        Provider provider = iProviderRepo.findById(id).get();
        if(provider.getStatusProvider()==1) {
            provider.setStatusProvider(2);
        }else provider.setStatusProvider(1);
        iProviderRepo.save(provider);
        return provider;
    }

    @Override
    public Provider save(Provider provider) {
        return iProviderRepo.save(provider);
    }

    @Override
    public Provider findProviderByAccount_Id(Integer accountId) {
        return iProviderRepo.findProviderByAccount_Id(accountId);
    }

    @Override
    public Provider findProviderByAccountUsername(String username) {
        return iProviderRepo.findProviderByAccount_Username(username);
    }
}
