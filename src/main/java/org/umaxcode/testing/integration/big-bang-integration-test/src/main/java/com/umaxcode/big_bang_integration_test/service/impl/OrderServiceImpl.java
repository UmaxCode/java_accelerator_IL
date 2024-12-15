package com.umaxcode.big_bang_integration_test.service.impl;

import com.umaxcode.big_bang_integration_test.domain.dto.OrderPlacementRequestDTO;
import com.umaxcode.big_bang_integration_test.domain.entity.Order;
import com.umaxcode.big_bang_integration_test.domain.entity.Product;
import com.umaxcode.big_bang_integration_test.repository.OrderRepository;
import com.umaxcode.big_bang_integration_test.service.OrderService;
import com.umaxcode.big_bang_integration_test.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Override
    public Order placeOrder(OrderPlacementRequestDTO request) {

        Product availableProduct = productService.getProductIfInStock(
                request.productId(),
                request.quantity()
        );

        Order order = Order.builder()
                .quantity(request.quantity())
                .product(availableProduct)
                .build();

        availableProduct.setQuantity(
                availableProduct.getQuantity() - request.quantity());

        productService.saveProduct(availableProduct);

        return orderRepository.save(order);
    }
}
