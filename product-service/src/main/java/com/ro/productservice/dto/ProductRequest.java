package com.ro.productservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequest {	
	private String name;
	private String description;
	private String skuCode;
	private BigDecimal price;
	
}
