package com.kootoncalli.kooton_calli.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kootoncalli.kooton_calli.model.SaleProduct;
import com.kootoncalli.kooton_calli.model.SaleProductId;


public interface SaleProductRepository extends CrudRepository<SaleProduct, SaleProductId>{
    Optional<SaleProductRepository> findProductoSaleProductsAmount(Integer products_amount);


    Optional<SaleProduct> findByProductsAmount(Integer productsAmount);
}
