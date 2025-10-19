package com.kootoncalli.kooton_calli.service;

import com.kootoncalli.kooton_calli.dto.SaleProductDto;

public interface SaleProductService {

    //Declaramos los metodos CRUD en la inferfaz
    SaleProductDto save(SaleProductDto saleProductDto);
    SaleProductDto findById(SaleProductDto saleProductDto);

    Iterable<SaleProductDto> findAll();
    SaleProductDto update(Integer idSaleProduct, SaleProductDto saleProduct);
    void deleteByID(Integer idSaleProduct);

    public SaleProductDto getSaleProductById(Integer id);


}
