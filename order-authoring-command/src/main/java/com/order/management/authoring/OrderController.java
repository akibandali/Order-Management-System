package com.order.management.authoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/order")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<OrderRequestDTO> getOrderById (@PathVariable String id) {
        OrderRequestDTO Order = orderService.getOrderById(id);
        return new ResponseEntity<>(Order, HttpStatus.OK);
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Long> createNewOrder (@RequestBody OrderRequestDTO Order) {
        return new ResponseEntity<>(orderService.createNewOrder(Order), HttpStatus.CREATED);
    }

/*    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<Void> updateOrder (@PathVariable String id, @RequestBody OrderRequestDTO Order) {
        OrderService.updateOrder(id, Order);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<OrderRequestDTO>> getOrderByStatus (@RequestParam String status) {
        return new ResponseEntity<>(OrderService.getOrdersByStatus(status), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<OrderRequestDTO> deleteOrder (@PathVariable String id) {
        OrderService.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

}
