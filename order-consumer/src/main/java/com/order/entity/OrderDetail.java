package com.order.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetail {
    private Long id;
    private LocalDateTime orderDate;
    private String status;
    private String itemName;
    private Integer quantity;
    private String customer;
    private String address;

}

