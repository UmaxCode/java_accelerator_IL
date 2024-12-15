package com.umaxcode.integration_test.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long userId;
    private Long productId;
    private Long quantity;

    @Override
    public String toString() {
        return "Order [id=" + id + ", userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
    }
}