package com.ro.productservice.service;

import com.ro.productservice.dto.ProductRequest;


public interface ProductService {
	// Process request data
	public void createProduct(ProductRequest productRequest);
}
