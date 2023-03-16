package com.be_casemd6.service;


import com.be_casemd6.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();

    List<Order> getAllOrderByStatus(int status);
    List<Order> getAllBillOfProviderById(int idProvider);
    List<Order> getAllBillOfAccountById(int idAccount);
    List<Order> getAllBillOfAccountByIdAndStartOrder(int idAccount, int statusOrder);
    List<Order> getAllBillOfProviderAndStartOrder(int idProvider, int statusOrder);

    Order findOrderById(int id);
}
