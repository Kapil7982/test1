package com.loqo.services;



import com.loqo.models.Product;

import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;

/**
 * Specification class for creating dynamic queries for products.
 */
public class ProductSpecification {
    
	/**
     * Builds a specification for filtering products based on the given criteria.
     *
     * @param category The category of the products.
     * @param minPrice The minimum price of the products.
     * @param maxPrice The maximum price of the products.
     * @param inStock  The stock availability of the products.
     * @return A specification for querying products.
     */
    public static Specification<Product> getProducts(String category, Double minPrice, Double maxPrice, Boolean inStock) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            
            if (category != null) {
                predicates.add(criteriaBuilder.equal(root.get("category"), category));
            }
            if (minPrice != null && maxPrice != null) {
                predicates.add(criteriaBuilder.between(root.get("price"), minPrice, maxPrice));
            }
            if (inStock != null) {
                predicates.add(criteriaBuilder.equal(root.get("inStock"), inStock));
            }
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

