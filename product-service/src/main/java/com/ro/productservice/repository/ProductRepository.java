package com.ro.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ro.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>, CustomProductRepository {

}
