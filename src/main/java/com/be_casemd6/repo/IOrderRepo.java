package com.be_casemd6.repo;

import com.be_casemd6.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IOrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findAll();

    @Query(nativeQuery = true, value = "SELECT * from order_lover where order_lover.status_order = 1")
    List<Order> getAllOrderUnShipped();

    @Query(nativeQuery = true, value = "SELECT * from order_lover where order_lover.status_order = 2")
    List<Order> getAllOrderPending();

    @Query(nativeQuery = true, value = "SELECT * from order_lover where order_lover.status_order = 3")
    List<Order> getAllOrderConfirmed();

    @Query(nativeQuery = true, value = "SELECT * from order_lover where order_lover.status_order = 4")
    List<Order> getAllOrderRejected();

    @Query(nativeQuery = true, value = "SELECT * from order_lover where order_lover.status_order = 5")
    List<Order> getAllOrderCompleted();

    @Query(nativeQuery = true, value = "SELECT * from order_lover where order_lover.status_order = :status_order")
    List<Order> getAllOrderByStatus(@Param("status_order") int status_order);

    @Query(nativeQuery = true, value = "SELECT * FROM order_lover WHERE order_lover.status_order != 1 AND order_lover.provider_id = :provider_id")
    List<Order> getAllBillOfProviderById(@Param("provider_id") int provider_id);

    @Query(nativeQuery = true, value = "SELECT * FROM order_lover WHERE order_lover.status_order = :status_order AND order_lover.provider_id = :provider_id")
    List<Order> getAllBillOfProviderAndStartOrder(@Param("provider_id") int provider_id, @Param("status_order") int status_order);


    @Query(nativeQuery = true, value = "SELECT * FROM order_lover WHERE order_lover.status_order != 1 AND order_lover.account_id = :account_id")
    List<Order> getAllBillOfAccountById(@Param("account_id") int account_id);

    @Query(nativeQuery = true, value = "SELECT * FROM order_lover WHERE order_lover.status_order = :status_order AND order_lover.account_id = :account_id")
    List<Order> getAllBillOfAccountByIdAndStartOrder(@Param("account_id") int account_id, @Param("status_order") int status_order);


    @Query(nativeQuery = true, value = " SELECT * FROM order_lover  WHERE order_lover.account_id = :account_id and order_lover.provider_id=:provider_id and order_lover.status_order = 5")
    List<Order> findOrderByAccountIdAndProviderId(@Param("account_id") int idAccount, @Param("provider_id") int idProvider);

    @Query(nativeQuery = true, value = "SELECT * FROM order_lover WHERE order_lover.status_order = 3 AND order_lover.provider_id = :provider_id")
    List<Order> getAllOrderOfProviderHaveStatus3(@Param("provider_id") int provider_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Order as o SET o.statusOrder = 4 WHERE o.provider.id = ?1 and o.statusOrder = 2 and o.startOrder = ?2")
    void checkAndChangeToReject(Integer provider_id, String start_order);
}
