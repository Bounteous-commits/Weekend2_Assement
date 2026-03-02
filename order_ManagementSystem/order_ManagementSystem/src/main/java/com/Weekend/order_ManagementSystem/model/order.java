package com.Weekend.order_ManagementSystem.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class order {

    private String id;
    private String customerName;
    private orderType type;
    private double amount;
    private orderStatus status;
    private LocalDateTime createdAt;

    public order() {
        this.id = UUID.randomUUID().toString();
        this.status = orderStatus.NEW;
        this.createdAt = LocalDateTime.now();
    }

    public order(String customerName, orderType type, double amount) {
        this();
        this.customerName = customerName;
        this.type = type;
        this.amount = amount;
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public orderType getType() { return type; }
    public void setType(orderType type) { this.type = type; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public orderStatus getStatus() { return status; }
    public void setStatus(orderStatus status) { this.status = status; }
}