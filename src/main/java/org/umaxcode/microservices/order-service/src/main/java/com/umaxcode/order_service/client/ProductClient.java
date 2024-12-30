package com.umaxcode.order_service.client;

import com.umaxcode.order_service.domain.dto.request.ProductIdAndQuantity;
import com.umaxcode.order_service.domain.dto.response.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE", path = "/products")
public interface ProductClient {

    @PostMapping("/in-stock")
    List<ProductDto> getProductsInSock(@RequestBody List<ProductIdAndQuantity> request);
}
