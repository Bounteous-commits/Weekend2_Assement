package com.Weekend.order_ManagementSystem.processor;

import com.Weekend.order_ManagementSystem.logging.OrderFileLogger;
import com.Weekend.order_ManagementSystem.model.order;
import com.Weekend.order_ManagementSystem.model.orderStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class OrderProcessor {

    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    private final OrderFileLogger fileLogger;

    public OrderProcessor(OrderFileLogger fileLogger) {
        this.fileLogger = fileLogger;
    }

    public void process(order order1) {

        executor.submit(() -> {

            try {

                order1.setStatus(orderStatus.PROCESSING);

                Thread.sleep(1000);

                order1.setStatus(orderStatus.COMPLETED);

                fileLogger.log(order1);

            } catch (Exception e) {

                order1.setStatus(orderStatus.FAILED);
            }

        });
    }
}
