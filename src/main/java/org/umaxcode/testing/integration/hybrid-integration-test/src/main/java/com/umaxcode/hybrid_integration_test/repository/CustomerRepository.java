package com.umaxcode.hybrid_integration_test.repository;

import com.umaxcode.hybrid_integration_test.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
