package com.be_casemd6.repo;

import com.be_casemd6.model.Order;
import com.be_casemd6.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface IOrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findAll();
    @Query(nativeQuery = true, value = "SELECT * from order_lover where order_lover.status_order = :status_order")
    List<Order> getAllOrderByStatus(@Param("status_order") int status_order);
}
