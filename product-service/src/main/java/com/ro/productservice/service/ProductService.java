package com.ro.productservice.service;

import java.util.List;

import com.ro.productservice.dto.ProductRequest;
import com.ro.productservice.dto.ProductResponse;


public interface ProductService {
	// Process request data
	public void createProduct(ProductRequest productRequest);
	public List<ProductResponse> getAllProducts();
	public void deleteProduct(String productId);
	public void updateProduct(String productId,ProductRequest productRequest);
}
