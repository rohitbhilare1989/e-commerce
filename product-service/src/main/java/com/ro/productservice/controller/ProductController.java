package com.ro.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ro.productservice.dto.ProductRequest;
import com.ro.productservice.dto.ProductResponse;
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
		return new ResponseEntity<String>("Product Created!", HttpStatus.CREATED);
	}

	@GetMapping
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") String productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Product Deleted!", HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<String> updateProduct(@PathVariable("id") String productId,@RequestBody ProductRequest productRequest) {

		productService.updateProduct(productId,productRequest);
		return new ResponseEntity<String>("Product Updated!", HttpStatus.OK);
	}
	
}
