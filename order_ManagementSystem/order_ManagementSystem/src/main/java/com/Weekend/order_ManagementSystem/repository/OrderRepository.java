package com.Weekend.order_ManagementSystem.repository;


import com.Weekend.order_ManagementSystem.model.order;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {

    private final Map<String, order> orders = new ConcurrentHashMap<>();

    public void save(order order1) {
        orders.put(order1.getOrderId(), order1);
    }

    public order findById(String id) {
        return orders.get(id);
    }

    public List<order> findAll() {
        return new ArrayList<>(orders.values());
    }
}