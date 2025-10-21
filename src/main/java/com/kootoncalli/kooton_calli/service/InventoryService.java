package com.kootoncalli.kooton_calli.service;

import com.kootoncalli.kooton_calli.dto.InventoryDto;

public interface InventoryService {

    InventoryDto save(InventoryDto inventoryDto);
    InventoryDto findById(Integer id);
    Iterable<InventoryDto> findAll();
    InventoryDto update(Integer id, InventoryDto inventoryDto);
    void deleteByID(Integer id);
   
    
}
