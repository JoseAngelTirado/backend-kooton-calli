package com.kootoncalli.kooton_calli.util; // O un paquete similar como .loader o .util

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kootoncalli.kooton_calli.model.Inventory;
import com.kootoncalli.kooton_calli.repository.InventoryRepository;

/**
 * Clase de carga de datos iniciales para la entidad Inventory.
 * Se ejecuta automáticamente después de que se inicia la aplicación.
 */
@Component
public class InventoryDataLoader implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;

    // Inyección de dependencia del repositorio
    public InventoryDataLoader(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    /**
     * El método run se ejecuta al inicio de la aplicación.
     */
    @Override
    public void run(String... args) throws Exception {
        // Lógica para verificar y cargar datos solo si el inventario está vacío
        if (inventoryRepository.count() == 0) {
            loadInitialInventoryData();
        }
    }

    private void loadInitialInventoryData() {
        System.out.println("Cargando datos iniciales de Inventario...");

        // Nota: id=null para que la base de datos genere el ID automáticamente
        
        // Producto ID 1: Camiseta Talla M
        Inventory item1 = new Inventory(
                null, // id
                1,    // productId (FK)
                50,   // quantity
                "M",  // productSize
                new BigDecimal("299.99"), // productPrice
                "BARC12345678901M" // barCode
        );

        // Producto ID 1: Camiseta Talla L
        Inventory item2 = new Inventory(
                null, // id
                1,    // productId (FK)
                30,   // quantity
                "L",  // productSize
                new BigDecimal("299.99"), // productPrice
                "BARC12345678901L" // barCode
        );

        // Producto ID 2: Pantalón Talla S
        Inventory item3 = new Inventory(
                null, // id
                2,    // productId (FK)
                15,   // quantity
                "S",  // productSize
                new BigDecimal("549.50"), // productPrice
                "BARC98765432102S" // barCode
        );
        
        // Guarda todos los ítems en la base de datos
        inventoryRepository.saveAll(List.of(item1, item2, item3));
        
        System.out.println("Inventario inicial cargado exitosamente. Total de registros: " + inventoryRepository.count());
    }
}