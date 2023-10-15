package com.ro.productservice.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value="product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
	
	@Id
	private String id;
	private String name;
	private String description;
	private String skuCode;
	private BigDecimal price;
	
	// productCategory
	
	private Date createdAt;
	private Date modifiedAt;
	
	
}
