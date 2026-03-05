package com.Weekend.order_ManagementSystem.model;

public class order {

    private String orderId;
    private String customerId;
    private double price;
    private int quantity;
    private orderType type;
    private orderStatus status;

    // Default constructor (needed for JSON deserialization)
    public order() {
    }

    // Parameterized constructor
    public order(String orderId, String customerId, double price, int quantity, orderType type) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.status = orderStatus.CREATED;
    }

    // Calculate total order amount
    public double getTotalAmount() {
        return price * quantity;
    }

    // Getters and Setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public orderType getType() {
        return type;
    }

    public void setType(orderType type) {
        this.type = type;
    }

    public orderStatus getStatus() {
        return status;
    }

    public void setStatus(orderStatus status) {
        this.status = status;
    }

    // Optional: useful for logging/debugging
    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}