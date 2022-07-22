package com.order.event;

 import com.event.OrderStream;
import com.order.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

 import static com.event.Constants.INPUT;

@Component
@Slf4j
public class OrderConsumer {

    private final  OrderStream OrderStream;

    public OrderConsumer (OrderStream loansStreams) {
        this.OrderStream = loansStreams;
    }

    @StreamListener(value =INPUT)
    public void handleEvent (Message<OrderDetail> order) throws Exception {
        log.info("Consuming order on partition {}", order.getHeaders().get("kafka_receivedPartitionId"));
        log.info("Consuming order {}",order);

    }

}
