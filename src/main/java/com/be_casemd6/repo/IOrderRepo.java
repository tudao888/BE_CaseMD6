package com.be_casemd6.repo;

import com.be_casemd6.model.Order;
import com.be_casemd6.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface IOrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findAll();

    @Query(nativeQuery = true, value = "SELECT * from order where order.status_order = 1")
    List<Order> getAllOrderUnShipped();
    @Query(nativeQuery = true, value = "SELECT * from order where order.status_order = 2")
    List<Order> getAllOrderPending();
    @Query(nativeQuery = true, value = "SELECT * from order where order.status_order = 3")
    List<Order> getAllOrderConfirmed();
    @Query(nativeQuery = true, value = "SELECT * from order where order.status_order = 4")
    List<Order> getAllOrderRejected();
    @Query(nativeQuery = true, value = "SELECT * from order where order.status_order = 5")
    List<Order> getAllOrderCompleted();

    @Query(nativeQuery = true, value = "SELECT * from order_lover where order_lover.status_order = :status_order")
    List<Order> getAllOrderByStatus(@Param("status_order") int status_order);

    @Query(nativeQuery = true, value = "SELECT * FROM order_lover WHERE order_lover.provider_id = :provider_id")
    List<Order> getProviderById(@Param("provider_id") int provider_id);
}
