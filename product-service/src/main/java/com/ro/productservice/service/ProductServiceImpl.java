package com.ro.productservice.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ro.productservice.dto.ProductRequest;
import com.ro.productservice.model.Product;
import com.ro.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.skuCode(productRequest.getSkuCode())
				.price(productRequest.getPrice())
				.createdAt(new Date())
				.modifiedAt(new Date())
				.build();
		productRepository.save(product);
		log.info("Product Service Called");
	}
}

