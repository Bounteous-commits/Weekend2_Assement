package com.Weekend.order_ManagementSystem.repository;


import com.Weekend.order_ManagementSystem.model.order;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class OrderRepository {

    private final Map<String, order> orderStore = new HashMap<>();

    public void save(order order) {
        orderStore.put(order.getId(), order);
    }

    public Optional<order> findById(String id) {
        return Optional.ofNullable(orderStore.get(id));
    }

    public List<order> findAll() {
        return new ArrayList<>(orderStore.values());
    }
}
