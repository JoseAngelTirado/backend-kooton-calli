package com.kootoncalli.kooton_calli.service;

import com.kootoncalli.kooton_calli.dto.DiscountDto;

public interface DiscountService {
     //---------- CRUD Methods -----------

     DiscountDto save(DiscountDto discountDto);
     DiscountDto findById(Integer id);

     Iterable<DiscountDto> findAll();

     DiscountDto update(Integer id, DiscountDto discount);
     void deleteByID(Integer id);

}
