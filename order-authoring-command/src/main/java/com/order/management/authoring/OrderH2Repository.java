package com.order.management.authoring;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderH2Repository extends JpaRepository<OrderDetail, Long> {

}
