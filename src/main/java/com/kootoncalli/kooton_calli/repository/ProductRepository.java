package com.kootoncalli.kooton_calli.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.kootoncalli.kooton_calli.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Iterable<Product> findAllByDescriptionContaining(String description);

    // AÑADE ESTOS MÉTODOS:
    @EntityGraph(attributePaths = {"inventories"})
    List<Product> findAll();
    
    @EntityGraph(attributePaths = {"inventories"})
    Optional<Product> findById(Integer id);

}
