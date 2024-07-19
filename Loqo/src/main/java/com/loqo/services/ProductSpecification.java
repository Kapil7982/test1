package com.loqo.services;



import com.loqo.models.Product;

import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {
    
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

