package com.order.management.event;


 import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderStream {

    String OUTPUT = "order-produce";

    @Output(OUTPUT)
    MessageChannel publishOrders();
}
