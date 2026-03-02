package com.Weekend.order_ManagementSystem.service;


import com.Weekend.order_ManagementSystem.model.order;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/orders")
class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public order createOrder(@RequestBody order order) {
        return service.createOrder(order);
    }

    @GetMapping("/{id}")
    public order getOrder(@PathVariable String id) {
        return service.getOrder(id);
    }

    @GetMapping
    public List<order> getAll() {
        return service.getAllOrders();
    }

    @GetMapping("/analytics/total")
    public double totalAmount() {
        return service.getTotalAmount();
    }

    @GetMapping("/analytics/buy-sell")
    public Map<String, Long> buyVsSell() {
        return service.getBuyVsSellCount();
    }

    @GetMapping("/analytics/top-customer")
    public String topCustomer() {
        return service.getTopCustomer();
    }

    @GetMapping("/analytics/group-status")
    public Map<?, List<order>> groupStatus() {
        return service.groupByStatus();
    }
}