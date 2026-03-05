package com.Weekend.order_ManagementSystem.logging;

//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;

import com.Weekend.order_ManagementSystem.model.order;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class OrderFileLogger {

    private static final String FILE = "order_logs.txt";

    public synchronized void log(order order1) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {

            writer.write(order1.getOrderId() + "," +
                    order1.getCustomerId() + "," +
                    order1.getStatus());

            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}