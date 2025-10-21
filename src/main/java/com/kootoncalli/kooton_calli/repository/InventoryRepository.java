package com.kootoncalli.kooton_calli.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kootoncalli.kooton_calli.model.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer>{


List<Inventory> findByIdProduct(Integer idProduct);
Optional<Inventory> findByBarCode(String barCode);
    
}
