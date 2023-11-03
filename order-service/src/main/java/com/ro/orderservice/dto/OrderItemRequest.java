package com.ro.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemRequest {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
