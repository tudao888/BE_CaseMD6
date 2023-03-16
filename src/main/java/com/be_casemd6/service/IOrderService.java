package com.be_casemd6.service;


import com.be_casemd6.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();

    List<Order> getAllOrderByStatus(int status);
    List<Order> getAllBillOfProviderById(int idProvider);

    Order findOrderById(int id);
}
