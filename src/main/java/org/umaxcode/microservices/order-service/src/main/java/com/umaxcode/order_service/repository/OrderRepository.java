package com.umaxcode.order_service.repository;

import com.umaxcode.order_service.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
