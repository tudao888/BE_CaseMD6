package com.be_casemd6.service.impl;

import com.be_casemd6.model.Provider;
import com.be_casemd6.model.Provision;
import com.be_casemd6.repo.IAccountRepo;
import com.be_casemd6.repo.IProvisionProviderRepo;
import com.be_casemd6.repo.IProvisionRepo;
import com.be_casemd6.service.IProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvisionService implements IProvisionService {
    @Autowired
    IProvisionRepo iProvisionRepo;

    @Override
    public Provision save(Provision provision) {
        return iProvisionRepo.save(provision);
    }

    @Override
    public List<Provision> findAllBasicProvision() {
        return iProvisionRepo.findAllBasicProvision();
    }

    @Override
    public List<Provision> findAllFreeProvision() {
        return iProvisionRepo.findAllFreeProvision();
    }

    @Override
    public List<Provision> findAllExtendProvision() {
        return iProvisionRepo.findAllExtendProvision();
    }

    @Override
    public Provision findProvisionById(Integer id) {
        return iProvisionRepo.findById(id).get();
    }


}
