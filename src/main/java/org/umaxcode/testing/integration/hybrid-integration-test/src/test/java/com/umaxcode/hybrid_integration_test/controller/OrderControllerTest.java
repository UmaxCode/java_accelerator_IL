package com.umaxcode.hybrid_integration_test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umaxcode.hybrid_integration_test.domain.dto.OrderRequest;
import com.umaxcode.hybrid_integration_test.domain.entity.OrderItem;
import com.umaxcode.hybrid_integration_test.domain.entity.Product;
import com.umaxcode.hybrid_integration_test.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(
        locations = "classpath:application-test.properties")
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void setUp() {
        Product productInstance = Product.builder()
                .name("Product 1")
                .price(120.00)
                .quantity(4)
                .build();

        product = productRepository.save(productInstance);
    }

    @Test
    void createOrder_ShouldAllowACustomerToMakeAnOrder() throws Exception {
        OrderItem requestItem = OrderItem.builder()
                .quantity(4)
                .product(product)
                .build();

        OrderRequest request = OrderRequest.builder()
                .customerId(1L)
                .items(List.of(requestItem))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items[0].quantity").value(requestItem.getQuantity()))
                .andExpect(jsonPath("$.items[0].product.id").value(requestItem.getProduct().getId()))
                .andExpect(jsonPath("$.items[0].product.name").value(product.getName()))
                .andExpect(jsonPath("$.items[0].product.price").value(product.getPrice()));
    }
}