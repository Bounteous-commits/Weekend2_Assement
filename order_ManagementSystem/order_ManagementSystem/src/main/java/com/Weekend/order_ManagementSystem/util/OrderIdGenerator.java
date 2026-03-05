package com.Weekend.order_ManagementSystem.util;

import java.util.UUID;

public class OrderIdGenerator {

    public static String generate() {
        return UUID.randomUUID().toString();
    }
}