package com.kootoncalli.kooton_calli.service;

import java.util.List;

import com.kootoncalli.kooton_calli.dto.InventoryDto;

public interface InventoryService {

    InventoryDto save(InventoryDto inventoryDto);
    InventoryDto findById(Integer id);
    Iterable<InventoryDto> findAll();
    InventoryDto update(Integer id, InventoryDto inventoryDto);
    void deleteByID(Integer id);
   
    // --- Métodos de Búsqueda Personalizados ---
    
    /**
     * Busca todas las entradas de inventario por ID de producto (FK).
     */
    List<InventoryDto> findByProductId(Integer idProduct);
    
    /**
     * Busca una entrada de inventario por su código de barras.
     */
    InventoryDto findByBarCode(String barCode);
    
}
