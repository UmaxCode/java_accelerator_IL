package com.umaxcode.big_bang_integration_test.repository;

import com.umaxcode.big_bang_integration_test.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
