package com.be_casemd6.service.impl;

import com.be_casemd6.model.Order;
import com.be_casemd6.model.Provider;
import com.be_casemd6.repo.IOrderRepo;
import com.be_casemd6.repo.IProviderRepo;
import com.be_casemd6.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProviderService implements IProviderService {
    @Autowired
    IProviderRepo iProviderRepo;
    @Autowired
    IOrderRepo iOrderRepo;


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
    public List<Provider> getAllProvider() {
        return (List<Provider>) iProviderRepo.findAll();
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
        provider.setView(provider.getView() + 1);
        iProviderRepo.save(provider);
        return provider;
    }

    @Override
    public Provider changeStatusProvider(Integer id) {
        Provider provider = iProviderRepo.findById(id).get();
        if (provider.getStatusProvider() == 1) {
            provider.setStatusProvider(2);
        } else provider.setStatusProvider(1);
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
    @Override
    public List<Provider> getNewProviders() {
        return iProviderRepo.get12NewProvider();
    }

    @Override
    public Map<Provider, Integer> getProvidersByOrderStatus5() {
        List<Order> orderList = iOrderRepo.getAllOrderCompleted();
        List<Provider> providers = new ArrayList<>();
        Set<Provider> providerSet = new HashSet<>();
        for (int i = 0; i < orderList.size(); i++) {
            providers.add(orderList.get(i).getProvider());
            providerSet.add(orderList.get(i).getProvider());
        }
        int[] count = new int[providerSet.size()];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        List<Provider> providerList = new ArrayList<>();
        providerList.addAll(providerSet);
        Provider[] prs = new Provider[providerList.size()];
        for (int i = 0; i < prs.length; i++) {
            prs[i] = providerList.get(i);
        }

        for (int i = 0; i < providerList.size(); i++) {
            for (int j = 0; j < providers.size(); j++) {
                if (providerList.get(i).equals(providers.get(j))) {
                    count[i]++;
                }
            }
        }
        Map<Provider, Integer> map = new HashMap<>();

        for (int i = 0; i < prs.length; i++) {
            map.put(prs[i], count[i]);
            System.out.println(prs[i].getId() + " " + count[i]);
        }


        // Create a comparator to compare values in descending order
        Comparator<Provider> valueComparator = new Comparator<Provider>() {
            public int compare(Provider key1, Provider key2) {
                int value1 = map.get(key1);
                int value2 = map.get(key2);
                if (value1 == value2) {
                    return key1.getId().compareTo(key2.getId());
                }
                return value2 - value1;
            }
        };
        Map<Provider, Integer> mapSort = new TreeMap<>(valueComparator);
        mapSort.putAll(map);
        Set<Provider> set = mapSort.keySet();
        System.out.println("---------------- after sort -------------------");
        for (Provider provider : set) {
            System.out.println(provider.getId()+" "+ mapSort.get(provider));
        }

        return mapSort;
    }

    @Override
    public List<Provider> findProvidersByAccount_FullNameContaining(String fullName) {
        return iProviderRepo.findProvidersByAccount_FullNameContaining(fullName);
    }
}
