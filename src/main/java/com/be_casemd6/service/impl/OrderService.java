package com.be_casemd6.service.impl;

import com.be_casemd6.model.Order;
import com.be_casemd6.model.Provider;
import com.be_casemd6.repo.IOrderRepo;
import com.be_casemd6.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepo iOrderRepo;


    @Override
    public List<Order> getAllOrders() {
        return iOrderRepo.findAll();
    }


    @Override
    public List<Order> getAllOrderByStatus(int status) {
        return iOrderRepo.getAllOrderByStatus(status);
    }

    @Override

    public Order createOrder(Order order) {
        return iOrderRepo.save(order);
    }


    public List<Order> getAllBillOfProviderById(int idProvider) {
        return iOrderRepo.getAllBillOfProviderById(idProvider);
    }

    @Override
    public List<Order> getAllBillOfAccountById(int idAccount) {
        return iOrderRepo.getAllBillOfAccountById(idAccount);
    }

    @Override
    public List<Order> getAllBillOfAccountByIdAndStartOrder(int idAccount, int statusOrder) {
        return iOrderRepo.getAllBillOfAccountByIdAndStartOrder(idAccount, statusOrder);
    }

    @Override
    public List<Order> getAllBillOfProviderAndStartOrder(int idProvider, int statusOrder) {
        return iOrderRepo.getAllBillOfProviderAndStartOrder(idProvider, statusOrder);
    }


    @Override
    public Order findOrderById(int id) {
        return iOrderRepo.findById(id).get();
    }

    @Override
    public List<Order> getAllOrderOfProviderHaveStatus3(int provider_id) {
        return iOrderRepo.getAllOrderOfProviderHaveStatus3(provider_id);
    }


    @Override
    public List<Order> findOrdersByStatus5() {
        return iOrderRepo.getAllOrderCompleted();
    }

}
