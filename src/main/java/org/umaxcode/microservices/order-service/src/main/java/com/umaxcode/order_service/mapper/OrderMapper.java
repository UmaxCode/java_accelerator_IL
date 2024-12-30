package com.umaxcode.order_service.mapper;

import com.umaxcode.order_service.domain.dto.request.ProductIdAndQuantity;
import com.umaxcode.order_service.domain.dto.response.OrderDto;
import com.umaxcode.order_service.domain.entity.Order;
import com.umaxcode.order_service.domain.entity.OrderItem;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

    public static OrderDto toOrderDto(Order order) {

        List<ProductIdAndQuantity> orderItems = order.getOrderItems()
                .stream()
                .map(orderItem -> ProductIdAndQuantity.builder()
                        .id(orderItem.getProductId())
                        .quantity(orderItem.getQuantity())
                        .build())
                .toList();

        return OrderDto.builder()
                .id(order.getId())
                .orderItems(orderItems)
                .build();
    }

    public static List<OrderItem> toOrderItem(List<ProductIdAndQuantity> idQuantList) {

        return idQuantList.stream()
                .map(idQuant -> OrderItem.builder()
                        .productId(idQuant.id())
                        .quantity(idQuant.quantity())
                        .build())
                .toList();
    }

    public static List<OrderDto> toOrderDtoList(List<Order> orders) {
        return orders.stream().map(OrderMapper::toOrderDto).toList();
    }
}
