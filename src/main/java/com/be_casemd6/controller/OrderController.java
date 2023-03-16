package com.be_casemd6.controller;

import com.be_casemd6.model.Order;
import com.be_casemd6.repo.IOrderRepo;
import com.be_casemd6.service.IOrderService;
import com.be_casemd6.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private IOrderRepo iOrderRepo;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/{statusOrder}")
    public ResponseEntity<List<Order>> getAllOrderByStatus(@PathVariable int statusOrder) {
        return new ResponseEntity<>(orderService.getAllOrderByStatus(statusOrder), HttpStatus.OK);
    }

    @PostMapping("/changeToConfirmed/{id}")
    public ResponseEntity<Order> changeToConfirmed(@PathVariable int id) {
        Order order = orderService.findOrderById(id);
        if (order.getStatusOrder() == 2) {
            order.setStatusOrder(3);
        }
        return new ResponseEntity<>(iOrderRepo.save(order), HttpStatus.OK);
    }

    @PostMapping("/changeToRejected/{id}")
    public ResponseEntity<Order> changeToRejected(@PathVariable int id) {
        Order order = orderService.findOrderById(id);
        if (order.getStatusOrder() == 2) {
            order.setStatusOrder(4);
        }
        return new ResponseEntity<>(iOrderRepo.save(order), HttpStatus.OK);
    }
}
