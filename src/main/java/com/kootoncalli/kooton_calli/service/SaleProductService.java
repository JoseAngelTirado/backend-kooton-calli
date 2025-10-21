package com.kootoncalli.kooton_calli.service;

import com.kootoncalli.kooton_calli.dto.SaleProductDto;

public interface SaleProductService {

    //Declaramos los metodos CRUD en la inferfaz
    SaleProductDto save(SaleProductDto saleProductDto);
    SaleProductDto findById(Integer idTicket, Integer idProduct, SaleProductDto saleProduct);

    Iterable<SaleProductDto> findAll();
    SaleProductDto update(Integer idTicket, Integer idProduct, SaleProductDto saleProduct);
    void deleteByID(Integer idTicket, Integer idProduct);

    public SaleProductDto getSaleProductById(Integer id);


}