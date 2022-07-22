package com.order.management.authoring;

import com.order.management.event.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderProducer producer;
    @Autowired
    private OrderH2Repository orderH2Repository;

    public OrderRequestDTO getOrderById (String id) {
        OrderDetail orderEntity = orderH2Repository.findById(Long.valueOf(id)).get();
        OrderRequestDTO Order = OrderRequestDTO.builder()
                                               .id(orderEntity.getId())
                                               .itemName(orderEntity.getItemName())
                                               .address(orderEntity.getAddress())
                                               .quantity(orderEntity.getQuantity())
                                               .status(orderEntity.getStatus())
                                               .orderDate(orderEntity.getOrderDate())
                                               .customer(orderEntity.getCustomer())
                                               .build();
        return Order;
    }

    public Long createNewOrder (OrderRequestDTO request) {
        OrderDetail order = OrderDetail.builder()
                                       .customer(request.getCustomer())
                                       .itemName(request.getItemName())
                                       .orderDate(request.getOrderDate())
                                       .quantity(request.getQuantity())
                                       .address(request.getAddress())
                                       .status(request.getStatus())
                                       .build();
        orderH2Repository.save(order);
        producer.sendOrder(order);
        return order.getId();

    }

    /*
     * public List<OrderRequestDTO> getOrdersByStatus (String status) { List<Order> OrderList =
     * OrderH2Repository.findAll(); OrderList.sort(Comparator.comparing(OrderRequestDTO::getOrderDate,
     * Comparator.nullsLast(Comparator.naturalOrder()))); return OrderList; }
     */

    /*
     * public void deleteOrderById (String id) { OrderRepository.deleteById(id); }
     */

    /*
     * public void updateOrder (String id, OrderRequestDTO request) { Order Order =
     * OrderH2Repository.findById(Long.valueOf(id)); if (request.getStatus() != null) {
     * Order.setStatus(request.getStatus()); } if (request.getAddress() != null) {
     * Order.setAddress(request.getAddress()); }
     * 
     * if (request.getOrderDate() != null) { Order.setOrderDate(request.getOrderDate()); }
     * OrderRepository.saveOrder(Order); }
     */
}
