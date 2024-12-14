package com.umaxcode.unit_test_with_mockito.entity;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;
    private int userId;
    private int productId;
    private int quantity;
}
