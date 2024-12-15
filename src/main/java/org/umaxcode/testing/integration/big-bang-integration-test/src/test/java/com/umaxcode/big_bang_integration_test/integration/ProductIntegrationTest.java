package com.umaxcode.big_bang_integration_test.integration;

import com.umaxcode.big_bang_integration_test.domain.entity.Product;
import com.umaxcode.big_bang_integration_test.repository.ProductRepository;
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
@TestPropertySource(
        locations = "classpath:application-test.properties")
@Transactional
class ProductIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        List<Product> products = List.of(
                Product.builder()
                        .name("Book")
                        .quantity(4)
                        .price(250.00)
                        .build(),

                Product.builder()
                        .name("Pencil")
                        .quantity(2)
                        .price(20.00)
                        .build()
        );

        productRepository.saveAll(products);

    }

    @Test
    void getProducts_ShouldRetrieveAllSavedProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Book"))
                .andExpect(jsonPath("$[0].quantity").value(4))
                .andExpect(jsonPath("$[0].price").value(250.00))
                .andExpect(jsonPath("$[1].name").value("Pencil"))
                .andExpect(jsonPath("$[1].quantity").value(2))
                .andExpect(jsonPath("$[1].price").value(20.00));
    }
}