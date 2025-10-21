package com.kootoncalli.kooton_calli.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kootoncalli.kooton_calli.model.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer>{

    // CORREGIDO: Spring ahora entiende "Buscar por el campo llamado 'productId'"
    List<Inventory> findByProductId(Integer productId);
    
    Optional<Inventory> findByBarCode(String barCode);
}