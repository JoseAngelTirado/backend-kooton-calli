package com.kootoncalli.kooton_calli.repository;

import org.springframework.data.repository.CrudRepository;

import com.kootoncalli.kooton_calli.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Iterable<Product> findAllByDescriptionContaining(String description);

}
