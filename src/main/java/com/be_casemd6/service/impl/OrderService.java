package com.be_casemd6.service.impl;

import com.be_casemd6.model.Order;
import com.be_casemd6.repo.IOrderRepo;
import com.be_casemd6.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepo iOrderRepo;

    @Override
    public List<Order> getAllOrders() {
        return iOrderRepo.findAll();
    }

    @Override
    public List<Order> getAllOrderUnShipped() {
        return iOrderRepo.getAllOrderUnShipped();
    }

    @Override
    public List<Order> getAllOrderPending() {
        return iOrderRepo.getAllOrderPending();
    }

    @Override
    public List<Order> getAllOrderConfirmed() {
        return iOrderRepo.getAllOrderConfirmed();
    }

    @Override
    public List<Order> getAllOrderRejected() {
        return iOrderRepo.getAllOrderRejected();
    }

    @Override
    public List<Order> getAllOrderCompleted() {
        return iOrderRepo.getAllOrderCompleted();
    }

    @Override
    public List<Order> getAllOrderByStatus(int status) {
        return iOrderRepo.getAllOrderByStatus(status);
    }

    @Override
    public Order save(Order order) {
        return iOrderRepo.save(order);
    }

}
