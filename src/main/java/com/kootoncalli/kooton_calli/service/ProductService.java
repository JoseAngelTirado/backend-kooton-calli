package com.kootoncalli.kooton_calli.service;

import com.kootoncalli.kooton_calli.dto.ProductDto;

public interface ProductService {

    //====== CRUD METHODS ======
    ProductDto save(ProductDto product);

    ProductDto findById(Integer id);

    Iterable<ProductDto> findAll();

    ProductDto update(Integer id, ProductDto product);

    void deleteById(Integer id);

    Iterable<ProductDto> findAllByDescription(String description);
    
}
