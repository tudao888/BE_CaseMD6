package com.be_casemd6.service.impl;

import com.be_casemd6.model.Bill;
import com.be_casemd6.repository.IBillRepo;
import com.be_casemd6.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    IBillRepo iBillRepo;
    @Override
    public List<Bill> getALlBill() {
        return (List<Bill>) iBillRepo.findAll();

    }
}
