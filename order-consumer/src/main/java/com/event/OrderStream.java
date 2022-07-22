package com.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

import static com.event.Constants.INPUT;
public interface OrderStream {

    @Input(INPUT)
    SubscribableChannel consumeOrders();

}
