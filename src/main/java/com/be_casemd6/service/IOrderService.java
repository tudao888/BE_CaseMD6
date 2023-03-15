package com.be_casemd6.service;


import com.be_casemd6.model.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();

    List<Order> getAllOrderByStatus(int status);
    List<Order> getProviderById(int idProvider);
}
