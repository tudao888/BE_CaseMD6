package com.be_casemd6.controller;

import com.be_casemd6.model.Order;
import com.be_casemd6.service.IOrderService;
import com.be_casemd6.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/{statusOrder}")
    public ResponseEntity<List<Order>> getAllOrderByStatus(@PathVariable int statusOrder) {
        return new ResponseEntity<>(orderService.getAllOrderByStatus(statusOrder), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        String dateOfOrder = new Date().toString();
        order.setDateOfOrder(dateOfOrder);
        return new ResponseEntity<Order>(orderService.createOrder(order),HttpStatus.OK);
    }

}
