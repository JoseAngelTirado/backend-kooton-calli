package com.kootoncalli.kooton_calli.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kootoncalli.kooton_calli.dto.InventoryDto;
import com.kootoncalli.kooton_calli.model.Inventory;
import com.kootoncalli.kooton_calli.model.Product;
import com.kootoncalli.kooton_calli.repository.InventoryRepository;
import com.kootoncalli.kooton_calli.repository.ProductRepository;
import com.kootoncalli.kooton_calli.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;

    //inyeccion de repositorios 
    public InventoryServiceImpl(InventoryRepository inventoryRepository, ProductRepository productRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
    }


    //metodo CRUD save
    @Override
    public InventoryDto save(InventoryDto inventoryDto) {
        if(inventoryDto.getIdProduct()==null){
            throw new IllegalArgumentException("Producto ID cannot be null");
        }
        Inventory inventoryToSave = inventoryDtoToInventory(inventoryDto);
        Inventory createdInventory = inventoryRepository.save(inventoryToSave);
        return inventoryToInventoryDto(createdInventory);
    }

     private Inventory inventoryDtoToInventory(InventoryDto inventoryDto) {
        Inventory inventory = new Inventory();
        inventory.setId(inventoryDto.getId());
        inventory.setBarCode(inventoryDto.getBarCode());
        inventory.setQuantity(inventoryDto.getQuantity());
        inventory.setProductSize(inventoryDto.getProductSize());
        inventory.setProductPrice(inventoryDto.getProductPrice());

        // Manejo de la relación con Product
        if (inventoryDto.getIdProduct() != null) {
            Product product = productRepository.findById(inventoryDto.getIdProduct())
                .orElseThrow(() -> new IllegalStateException("Product not found with id: " + inventoryDto.getIdProduct()));
            inventory.setProduct(product);
        }

        return inventory;
    }

    private InventoryDto inventoryToInventoryDto(Inventory inventory) {
        Integer productId = (inventory.getProduct() != null) ? inventory.getProduct().getId() : null;

        return new InventoryDto(
            inventory.getId(),
            productId,
            inventory.getQuantity(),
            inventory.getProductSize(),
            inventory.getProductPrice(),
            inventory.getBarCode()
        );
    }



    @Override
    public InventoryDto findById(Integer id) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
        if(inventoryOptional.isEmpty()){
            throw new IllegalStateException("The master table does not contain any register regarding id: "+ id);
            }
            Inventory existingInventory = inventoryOptional.get();
            return inventoryToInventoryDto(existingInventory);
    }

    @Override
    public Iterable<InventoryDto> findAll() {
        Iterable<Inventory> inventories = inventoryRepository.findAll();
        List<InventoryDto> inventoryDtos = new ArrayList<>();
        for(Inventory inventory : inventories){
            inventoryDtos.add(inventoryToInventoryDto(inventory));
        }
        return inventoryDtos;
    }

    @Override
    public InventoryDto update(Integer id, InventoryDto inventoryDto) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
        if(inventoryOptional.isEmpty()){
            throw new IllegalStateException("The master table does not contain any register regarding id: "+ id);
            }
            Inventory existingInventory = inventoryOptional.get();
            Inventory updatedInventory = InventoryDtoToInventory(inventoryDto);
            existingInventory.setBarCode(inventoryDto.getBarCode());
            existingInventory.setQuantity(inventoryDto.getQuantity());
            existingInventory.setProductSize(inventoryDto.getProductSize());
            existingInventory.setProductPrice(inventoryDto.getProductPrice());


            return inventoryToInventoryDto(inventoryRepository.save(updatedInventory));
    
    }

    @Override
    public void deleteByID(Integer id) {
        boolean exists = inventoryRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("The master table does not contain any register regarding id: "+ id);
        }
        inventoryRepository.deleteById(id);
    }

    

    private Inventory InventoryDtoToInventory(InventoryDto inventoryDto){
        Inventory inventory = new Inventory();
        inventory.setId(inventoryDto.getId());
        inventory.setBarCode(inventoryDto.getBarCode());
        inventory.setQuantity(inventoryDto.getQuantity());
        inventory.setProductSize(inventoryDto.getProductSize());
        inventory.setProductPrice(inventoryDto.getProductPrice());

        return inventory;
    }

    @Override
    public List<InventoryDto> findByProductId(Integer idProduct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByProductId'");
    }

    @Override
    public InventoryDto findByBarCode(String barCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByBarCode'");
    }
}

