package com.order.event;

 import com.event.OrderStream;
 import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OrderStream.class)
public class OrderStreamConfig {

}
