package com.be_casemd6.service;


import com.be_casemd6.model.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();

    List<Order> getAllOrderUnShipped();

    List<Order> getAllOrderPending();

    List<Order> getAllOrderConfirmed();
    List<Order> getAllOrderRejected();
    List<Order> getAllOrderCompleted();

    List<Order> getAllOrderByStatus(int status);

    Order save(Order order);
}
