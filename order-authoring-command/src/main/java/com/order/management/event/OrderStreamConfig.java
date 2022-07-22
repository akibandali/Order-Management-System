package com.order.management.event;

 import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OrderStream.class)
public class OrderStreamConfig {

}
