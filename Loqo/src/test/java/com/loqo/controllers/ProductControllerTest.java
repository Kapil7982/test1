package com.loqo.controllers;

import com.loqo.models.Product;
import com.loqo.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testGetProducts() throws Exception {
        Product product1 = new Product(1L, "Smartphone", "electronics", 299.99, true, 4.5, new Date());
        Product product2 = new Product(2L, "Laptop", "electronics", 899.99, true, 4.7, new Date());
        List<Product> products = Arrays.asList(product1, product2);

        when(productService.getProducts("electronics", 100.0, 1000.0, true, "price", "asc")).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders.get("/products")
                .param("category", "electronics")
                .param("minPrice", "100")
                .param("maxPrice", "1000")
                .param("inStock", "true")
                .param("sortField", "price")
                .param("sortOrder", "asc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Smartphone"))
                .andExpect(jsonPath("$[1].name").value("Laptop"));
    }
}
