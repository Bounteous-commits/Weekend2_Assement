package com.Weekend.order_ManagementSystem.service;

import com.Weekend.order_ManagementSystem.model.order;
import com.Weekend.order_ManagementSystem.processor.OrderProcessor;
import com.Weekend.order_ManagementSystem.repository.OrderRepository;
import com.Weekend.order_ManagementSystem.util.OrderIdGenerator;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final OrderProcessor processor;

    public OrderService(OrderRepository repository, OrderProcessor processor) {
        this.repository = repository;
        this.processor = processor;
    }

    public order createOrder(order order1) {

        order1.setOrderId(OrderIdGenerator.generate());

        repository.save(order1);

        processor.process(order1);

        return order1;
    }

    public List<order> getAllOrders() {
        return repository.findAll();
    }
}