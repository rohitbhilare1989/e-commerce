package com.ro.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ro.productservice.dto.ProductRequest;
import com.ro.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {
	
		productService.createProduct(productRequest);
		return new ResponseEntity<String>("Product Created!",HttpStatus.CREATED);
	}

}
