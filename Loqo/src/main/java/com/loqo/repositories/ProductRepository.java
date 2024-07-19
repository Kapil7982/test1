package com.loqo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.loqo.models.Product;

/**
 * Repository interface for Product entity.
 * Extends JpaRepository for basic CRUD operations.
 * Extends JpaSpecificationExecutor for query specification support.
 */
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}

