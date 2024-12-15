package com.umaxcode.big_bang_integration_test.repository;

import com.umaxcode.big_bang_integration_test.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByIdAndQuantityGreaterThanEqual(Long id, Integer quantity);
}
