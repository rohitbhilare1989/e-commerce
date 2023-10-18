package com.ro.productservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ro.productservice.dto.ProductRequest;
import com.ro.productservice.dto.ProductResponse;
import com.ro.productservice.exception.ResourceNotFound;
import com.ro.productservice.exception.ResourceNotFound;
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
		log.info("Product Service Called: createProduct");
	}
	
	public List<ProductResponse> getAllProducts(){
		List<Product> products= productRepository.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
	}
	
	public void deleteProduct(String productId){
		productRepository.deleteById(productId);
	}
	
	public void updateProduct(String productId,ProductRequest productRequest) {
		
		Optional<Product> productOpt = productRepository.findById(productId);
		
	
		if(productOpt.isPresent())
		{
			
			Product product = Product.builder()
					.id(productId)
					.name(productRequest.getName())
					.description(productRequest.getDescription())
					.skuCode(productRequest.getSkuCode())
					.price(productRequest.getPrice())
					.createdAt(productOpt.get().getCreatedAt())
					.modifiedAt(new Date())
					.build();
			productRepository.save(product);
		}	else {
			throw new ResourceNotFound("Product Not Found!");
		}
		

		log.info("Product Service Called: updateProduct");
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
		.id(product.getId())
		.name(product.getName())
		.description(product.getDescription())
		.skuCode(product.getSkuCode())
		.price(product.getPrice())
		.build();
	}
	
}

