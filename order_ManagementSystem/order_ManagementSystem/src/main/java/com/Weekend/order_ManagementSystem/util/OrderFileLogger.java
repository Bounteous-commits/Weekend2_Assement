package com.Weekend.order_ManagementSystem.util;

import com.Weekend.order_ManagementSystem.model.order;

import java.io.FileWriter;
import java.io.IOException;

public class OrderFileLogger {

    private static final String FILE_PATH = "order-log.txt";

    public synchronized void log(order order) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(order.getId() + "," +
                    order.getCustomerName() + "," +
                    order.getType() + "," +
                    order.getAmount() + "," +
                    order.getStatus() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
