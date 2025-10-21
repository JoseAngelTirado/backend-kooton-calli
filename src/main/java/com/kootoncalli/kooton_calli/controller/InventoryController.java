package com.kootoncalli.kooton_calli.controller;

import com.kootoncalli.kooton_calli.dto.InventoryDto;
import com.kootoncalli.kooton_calli.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    private final InventoryService inventoryService;

    // Inyección de dependencia del servicio por constructor
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // --- 1. POST: Crear nuevo inventario ---
    @PostMapping
    public ResponseEntity<InventoryDto> createInventory(@RequestBody InventoryDto inventoryDto) {
        // El servicio maneja el mapeo de DTO a Entidad y guarda el objeto
        InventoryDto createdInventory = inventoryService.save(inventoryDto);
        return new ResponseEntity<>(createdInventory, HttpStatus.CREATED);
    }

    // --- 2. GET: Obtener todos los registros ---
    @GetMapping
    public ResponseEntity<Iterable<InventoryDto>> getAllInventories() {
        Iterable<InventoryDto> inventories = inventoryService.findAll();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    // --- 3. GET: Obtener un registro por ID (PK) ---
    @GetMapping("/{id}")
    public ResponseEntity<InventoryDto> getInventoryById(@PathVariable Integer id) {
        InventoryDto inventoryDto = inventoryService.findById(id);
        // Si findById lanza IllegalStateException (no encontrado), el ControllerAdvice lo manejaría
        return new ResponseEntity<>(inventoryDto, HttpStatus.OK);
    }

    // --- 4. GET: Buscar por ID de Producto (FK) ---
    // Ejemplo: /api/inventories/product/5
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<InventoryDto>> getInventoriesByProductId(@PathVariable Integer productId) {
        List<InventoryDto> inventories = inventoryService.findByProductId(productId);
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }
    
    // --- 5. GET: Buscar por Código de Barras (Único) ---
    // Ejemplo: /api/inventories/barcode/12345678901234
    @GetMapping("/barcode/{barCode}")
    public ResponseEntity<InventoryDto> getInventoryByBarCode(@PathVariable String barCode) {
        InventoryDto inventoryDto = inventoryService.findByBarCode(barCode);
        return new ResponseEntity<>(inventoryDto, HttpStatus.OK);
    }


    // --- 6. PUT: Actualizar un registro existente ---
    @PutMapping("/{id}")
    public ResponseEntity<InventoryDto> updateInventory(@PathVariable Integer id, @RequestBody InventoryDto inventoryDto) {
        InventoryDto updatedInventory = inventoryService.update(id, inventoryDto);
        return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
    }

    // --- 7. DELETE: Eliminar un registro por ID ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Integer id) {
        inventoryService.deleteByID(id);
        // Retorna 204 No Content, que es el estándar para una eliminación exitosa sin cuerpo de respuesta.
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}