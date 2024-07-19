package com.loqo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.loqo.models.Product;
import com.loqo.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getProducts(String category, Double minPrice, Double maxPrice, Boolean inStock, String sortField, String sortOrder) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
        return productRepository.findAll(ProductSpecification.getProducts(category, minPrice, maxPrice, inStock), sort);
    }
}

