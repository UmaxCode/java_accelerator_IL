package com.umaxcode.hybrid_integration_test.repository;

import com.umaxcode.hybrid_integration_test.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
