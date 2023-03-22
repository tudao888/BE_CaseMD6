package com.be_casemd6.service;


import com.be_casemd6.model.Order;
import com.be_casemd6.model.Provider;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface IOrderService {
    List<Order> getAllOrders();

    List<Order> getAllOrderByStatus(int status);

    List<Order> findOrdersByStatus5();


    Order createOrder(Order order);

    List<Order> getAllBillOfProviderById(int idProvider);
    List<Order> getAllBillOfAccountById(int idAccount);
    List<Order> getAllBillOfAccountByIdAndStartOrder(int idAccount, int statusOrder);
    List<Order> getAllBillOfProviderAndStartOrder(int idProvider, int statusOrder);

    List<Order> getAllOrderOfProviderHaveStatus3(int provider_id);

    Order findOrderById(int id);

    List<Order>findOrderByAccountIdAndProviderId(int idAccount, int idProvider);
    void changeToReject(Integer id,String startOrder);

}
