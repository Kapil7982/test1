package com.loqo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.loqo.models.Product;
import com.loqo.services.ProductService;

import java.util.List;

/**
 * REST controller for managing products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    /**
     * Retrieves a list of products with optional filtering and sorting.
     *
     * @param category  The category of the products.
     * @param minPrice  The minimum price of the products.
     * @param maxPrice  The maximum price of the products.
     * @param inStock   The stock availability of the products.
     * @param sortField The field to sort the products by.
     * @param sortOrder The order to sort the products (asc/desc).
     * @return A list of products matching the criteria.
     */
    @GetMapping
    public List<Product> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Boolean inStock,
            @RequestParam(required = false, defaultValue = "createdAt") String sortField,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder) {
        return productService.getProducts(category, minPrice, maxPrice, inStock, sortField, sortOrder);
    }
}

