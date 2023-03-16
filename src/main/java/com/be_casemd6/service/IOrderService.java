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

    Order findOrderById(int id);

}
