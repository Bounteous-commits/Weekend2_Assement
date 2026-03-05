package com.Weekend.order_ManagementSystem.Controller;

import com.Weekend.order_ManagementSystem.analytics.OrderAnalyticsService;
import com.Weekend.order_ManagementSystem.model.order;
import com.Weekend.order_ManagementSystem.service.OrderService;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;
    private final OrderAnalyticsService analytics;

    public OrderController(OrderService service, OrderAnalyticsService analytics) {
        this.service = service;
        this.analytics = analytics;
    }

    @PostMapping
    public order create(@RequestBody order order1) {
        return service.createOrder(order1);
    }

    @GetMapping
    public List<order> all() {
        return service.getAllOrders();
    }

    @GetMapping("/analytics/total")
    public double totalAmount() {
        return analytics.totalOrderAmount();
    }

    @GetMapping("/analytics/buy-sell")
    public Map<?, ?> buySell() {
        return analytics.totalBuyVsSell();
    }
}