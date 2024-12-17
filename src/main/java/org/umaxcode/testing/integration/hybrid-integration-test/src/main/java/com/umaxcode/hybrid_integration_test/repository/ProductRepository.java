package com.umaxcode.hybrid_integration_test.repository;

import com.umaxcode.hybrid_integration_test.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
