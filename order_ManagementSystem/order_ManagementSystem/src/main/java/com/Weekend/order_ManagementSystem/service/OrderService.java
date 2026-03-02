package com.Weekend.order_ManagementSystem.service;

import com.Weekend.order_ManagementSystem.model.order;
import java.util.*;
public interface OrderService {

    order createOrder(order order);

    order getOrder(String id);

    List<order> getAllOrders();

    double getTotalAmount();

    Map<String, Long> getBuyVsSellCount();

    String getTopCustomer();

    Map<?, List<order>> groupByStatus();
}