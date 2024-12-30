package com.umaxcode.product_service.domain.dto.request;

import jakarta.validation.constraints.*;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductCreationDto(
        @NotNull(message = "Product name cannot be null")
        @NotBlank(message = "Product name cannot be empty")
        @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Product name must be alphanumeric and contain no special characters")
        String name,

        @NotNull(message = "Product name cannot be null")
        @NotBlank(message = "Product name cannot be empty")
        @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Product description must be alphanumeric and contain no special characters")
        String description,

        @NotNull(message = "Quantity cannot be null")
        @Min(value = 1, message = "Quantity must be greater than 0")
        @Max(value = 1000, message = "Quantity must be less than or equal to 1000")
        Integer quantity,

        @NotNull(message = "Price cannot be null")
        @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
        @Digits(integer = 10, fraction = 2, message = "Price must be a valid monetary amount with up to 10 integer digits and 2 fractional digits")
        BigDecimal price
) {
}
