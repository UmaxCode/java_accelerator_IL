package com.umaxcode.integration_test.repository;

import com.umaxcode.integration_test.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
