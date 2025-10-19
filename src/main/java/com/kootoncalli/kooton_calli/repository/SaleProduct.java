package com.kootoncalli.kooton_calli.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface SaleProduct extends CrudRepository<SaleProduct, Integer>{
    Optional<SaleProduct> findProductoSaleProductsAmount(Integer products_amount);

}
