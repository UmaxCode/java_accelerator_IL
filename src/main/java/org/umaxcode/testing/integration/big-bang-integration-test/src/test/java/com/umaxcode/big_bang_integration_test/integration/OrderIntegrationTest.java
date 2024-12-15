package com.umaxcode.big_bang_integration_test.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umaxcode.big_bang_integration_test.domain.dto.OrderPlacementRequestDTO;
import com.umaxcode.big_bang_integration_test.domain.entity.Product;
import com.umaxcode.big_bang_integration_test.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
@Transactional
class OrderIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRepository productRepository;

    private Long productId = null;

    @BeforeEach
    public void setUp() {
        Product product = Product.builder()
                .name("Eraser")
                .quantity(5)
                .price(240.00)
                .build();
        Product savedProduct = productRepository.save(product);
        productId = savedProduct.getId();
    }

    @Test
    void placeOrder_ShouldAllowSuccessfulPlacingOfOrder() throws Exception {

        OrderPlacementRequestDTO request = OrderPlacementRequestDTO.builder()
                .productId(productId)
                .quantity(3)
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.productQuantity").value(request.quantity()))
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.totalPrice").value(240.00 * request.quantity()));
    }

    @Test
    void placeOrder_ShouldThrowAndExceptionWhenProductIsOutOfStock() throws Exception {

        OrderPlacementRequestDTO request = OrderPlacementRequestDTO.builder()
                .productId(productId)
                .quantity(6)
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertInstanceOf(IllegalStateException.class, result.getResolvedException()));
    }
}