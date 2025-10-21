package com.kootoncalli.kooton_calli.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kootoncalli.kooton_calli.dto.InventoryDto;
import com.kootoncalli.kooton_calli.model.Inventory;
import com.kootoncalli.kooton_calli.repository.InventoryRepository;
import com.kootoncalli.kooton_calli.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    private Inventory inventoryDtoToInventory(InventoryDto inventoryDto){
        Inventory inventory = new Inventory();
        inventory.setId(inventoryDto.getId());
        inventory.setBarCode(inventoryDto.getBarCode());
        inventory.setQuantity(inventoryDto.getQuantity());
        inventory.setProductSize(inventoryDto.getProductSize());
        inventory.setProductPrice(inventoryDto.getProductPrice());

        return inventory;
    }

    @Override
    public InventoryDto save(InventoryDto inventoryDto) {
    
        inventoryDto.setId(null);
        Inventory inventoryToSave = inventoryDtoToInventory(inventoryDto);
        Inventory createdInventory = inventoryRepository.save(inventoryToSave);
        return inventoryToDto(createdInventory);
    }

    @Override
    public InventoryDto findById(Integer id) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
        if(inventoryOptional.isEmpty()){
            throw new IllegalStateException("The master table does not contain any register regarding id: "+ id);
            }
            Inventory existingInventory = inventoryOptional.get();
            return inventoryToDto(existingInventory);
    }

    @Override
    public Iterable<InventoryDto> findAll() {
        Iterable<Inventory> inventories = inventoryRepository.findAll();
        List<InventoryDto> inventoryDtos = new ArrayList<>();
        for(Inventory inventory : inventories){
            inventoryDtos.add(inventoryToDto(inventory));
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


            return inventoryToDto(inventoryRepository.save(updatedInventory));
    
    }

    @Override
    public void deleteByID(Integer id) {
        boolean exists = inventoryRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("The master table does not contain any register regarding id: "+ id);
        }
        inventoryRepository.deleteById(id);
    }

    private InventoryDto inventoryToDto(Inventory inventory){
        InventoryDto inventoryDto = new InventoryDto(
            inventory.getId(),
            inventory.getId(),
            inventory.getQuantity(),
            inventory.getProductSize(),
            inventory.getProductPrice(),
            inventory.getBarCode()
        );
        return inventoryDto;
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
}

