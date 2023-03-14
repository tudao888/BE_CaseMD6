package com.be_casemd6.controller;

import com.be_casemd6.model.Order;
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

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

//    @GetMapping("/unShipped")
//    public ResponseEntity<List<Order>> getAllOrderUnShipped() {
//        return new ResponseEntity<>(orderService.getAllOrderUnShipped(), HttpStatus.OK);
//    }
//
//    @GetMapping("/pending")
//    public ResponseEntity<List<Order>> getAllOrderPending() {
//        return new ResponseEntity<>(orderService.getAllOrderPending(), HttpStatus.OK);
//    }
//
//    @GetMapping("/confirmed")
//    public ResponseEntity<List<Order>> getAllOrderConfirmed() {
//        return new ResponseEntity<>(orderService.getAllOrderConfirmed(), HttpStatus.OK);
//    }
//
//    @GetMapping("/rejected")
//    public ResponseEntity<List<Order>> getAllOrderRejected() {
//        return new ResponseEntity<>(orderService.getAllOrderRejected(), HttpStatus.OK);
//    }
//
//    @GetMapping("/completed")
//    public ResponseEntity<List<Order>> getAllOrderCompleted() {
//        return new ResponseEntity<>(orderService.getAllOrderCompleted(), HttpStatus.OK);
//    }

        @GetMapping("/{status}")
    public ResponseEntity<List<Order>> getAllOrderByStatus(@PathVariable int status) {
        return new ResponseEntity<>(orderService.getAllOrderByStatus(status), HttpStatus.OK);
    }

}
