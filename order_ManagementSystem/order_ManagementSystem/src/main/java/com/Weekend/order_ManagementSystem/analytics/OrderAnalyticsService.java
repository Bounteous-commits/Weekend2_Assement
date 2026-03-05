package com.Weekend.order_ManagementSystem.analytics;

import com.Weekend.order_ManagementSystem.model.order;
import com.Weekend.order_ManagementSystem.model.orderType;
import com.Weekend.order_ManagementSystem.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderAnalyticsService {

    private final OrderRepository repository;

    public OrderAnalyticsService(OrderRepository repository) {
        this.repository = repository;
    }

    public double totalOrderAmount() {

        return repository.findAll()
                .stream()
                .mapToDouble(order::getTotalAmount)
                .sum();
    }

    public Map<orderType, Long> totalBuyVsSell() {

        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(order::getType, Collectors.counting()));
    }

    public String topCustomerByVolume() {

        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        order::getCustomerId,
                        Collectors.summingDouble(order::getTotalAmount)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Map<Object, List<order>> groupByStatus() {

        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(order::getStatus));
    }
}
