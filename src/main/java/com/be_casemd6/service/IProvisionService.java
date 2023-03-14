package com.be_casemd6.service;

import com.be_casemd6.model.Provider;
import com.be_casemd6.model.Provision;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProvisionService {

    Provision save(Provision provision);


    List<Provision> findAllBasicProvision();
    List<Provision> findAllFreeProvision();
    List<Provision> findAllExtendProvision();
}
