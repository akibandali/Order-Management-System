package com.order.management.event;

import com.order.management.authoring.OrderDetail;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderProducer {
    private final OrderStream OrderStream;

    public OrderProducer (OrderStream loansStreams) {
        this.OrderStream = loansStreams;
    }

    public void sendOrder (final OrderDetail Order) {
        log.info("Sending Order {} ", Order);
        MessageChannel messageChannel = OrderStream.publishOrders();
        messageChannel.send(MessageBuilder.withPayload(Order)
                                          .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                                          .setHeader("orderId", Order.getId())
                                          .build());
    }
}
