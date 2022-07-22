package com.order.management.authoring;

import java.time.LocalDateTime;

 import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderRequestDTO {
    private Long id;
    private LocalDateTime orderDate;
    private String status;
    private String itemName;
    private Integer quantity;
    private String customer;
    private String address;


}
