package com.loqo.services;


import com.loqo.models.Product;
import com.loqo.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the ProductService class.
 */
public class ProductServiceTest {
    
    @Mock
    private ProductRepository productRepository;
    
    @InjectMocks
    private ProductService productService;
    
    public ProductServiceTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetProducts() {
        Product product1 = new Product(1L, "Smartphone", "electronics", 299.99, true, 4.5, new Date());
        Product product2 = new Product(2L, "Laptop", "electronics", 899.99, true, 4.7, new Date());
        List<Product> products = Arrays.asList(product1, product2);
        
        when(productRepository.findAll(ProductSpecification.getProducts("electronics", 100.0, 1000.0, true), Sort.by(Sort.Direction.ASC, "price")))
                .thenReturn(products);
        
        List<Product> result = productService.getProducts("electronics", 100.0, 1000.0, true, "price", "asc");
        
        assertEquals(2, result.size());
        assertEquals("Smartphone", result.get(0).getName());
    }
}

