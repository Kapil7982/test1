package com.loqo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.loqo.models.Product;
import com.loqo.repositories.ProductRepository;

import java.util.List;

/**
 * Service class for managing products.
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    /**
     * Retrieves products based on various filtering and sorting criteria.
     *
     * @param category The category of the products.
     * @param minPrice The minimum price of the products.
     * @param maxPrice The maximum price of the products.
     * @param inStock  The stock availability of the products.
     * @param sortField The field to sort the products by.
     * @param sortOrder The order to sort the products (asc/desc).
     * @return A list of products matching the criteria.
     */
    public List<Product> getProducts(String category, Double minPrice, Double maxPrice, Boolean inStock, String sortField, String sortOrder) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
        return productRepository.findAll(ProductSpecification.getProducts(category, minPrice, maxPrice, inStock), sort);
    }
}

