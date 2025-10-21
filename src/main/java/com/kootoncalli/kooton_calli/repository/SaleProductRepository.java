package com.kootoncalli.kooton_calli.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kootoncalli.kooton_calli.model.SaleProduct;
import com.kootoncalli.kooton_calli.model.SaleProductId;


public interface SaleProductRepository extends CrudRepository<SaleProduct, SaleProductId>{
    
    // 1. Correct method to find all sale products with a specific quantity (productsAmount)
    // Returns a List because multiple sale records could have the same amount (e.g., 5 units)
    List<SaleProduct> findByProductsAmount(Integer productsAmount);

    // 2. Add a method to find all sale products for a specific Product ID (FK)
    // This is often needed in sale details entities.
    List<SaleProduct> findByProductId(Integer productId);
    
    // You should REMOVE the original problematic method:
    // Optional<SaleProductRepository> findProductoSaleProductsAmount(Integer products_amount);
}