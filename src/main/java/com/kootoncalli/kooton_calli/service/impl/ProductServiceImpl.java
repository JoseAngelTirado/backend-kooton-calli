package com.kootoncalli.kooton_calli.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.kootoncalli.kooton_calli.dto.InventoryDto;
import com.kootoncalli.kooton_calli.dto.ProductDto;
import com.kootoncalli.kooton_calli.model.Inventory;
import com.kootoncalli.kooton_calli.model.Product;
import com.kootoncalli.kooton_calli.repository.ProductRepository;
import com.kootoncalli.kooton_calli.service.ProductService;

@Service 
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<ProductDto> findAll() {
        List<ProductDto> productsDto = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        
        for (Product p : products) {
            productsDto.add(productToProductDto(p));
        }
        return productsDto;
    }

     // 🔹 OBTENER PRODUCTO POR ID
    @Override
    public ProductDto findById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Product with id " + id + " not found"));
        return productToProductDto(product); 
    }

    private ProductDto productToProductDto(Product product) {
        ProductDto productDto = new ProductDto(
            product.getId(),
            product.getName(),
            product.getSubcategory(),
            product.getCategory(),
            product.getDescription(),
            product.getImgUrl()
        );
        
        if (product.getInventories() != null && !product.getInventories().isEmpty()) {
            List<InventoryDto> inventoryDtos = new ArrayList<>();
            
            for (Inventory inventory : product.getInventories()) {
                inventoryDtos.add(convertInventoryToDto(inventory));
            }
            productDto.setInventories(inventoryDtos);
        }
        return productDto;
    }

    private InventoryDto convertInventoryToDto(Inventory inventory) {
        InventoryDto dto = new InventoryDto();
        dto.setId(inventory.getId());
        dto.setQuantity(inventory.getQuantity());
        dto.setProductSize(inventory.getProductSize());
        dto.setProductPrice(inventory.getProductPrice());
        dto.setBarCode(inventory.getBarCode());
        if (inventory.getProduct() != null) {
            dto.setIdProduct(inventory.getProduct().getId());
        }
        return dto;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
       productDto.setId(null); // Evita sobrescribir
    Product productToSave = productDtoToProduct(productDto);

    Product createdProduct = productRepository.save(productToSave);

    Product reloadedProduct = productRepository.findById(createdProduct.getId())
            .orElseThrow(() -> new IllegalStateException("Error reloading product after save"));

    return productToProductDto(reloadedProduct);
    }

    private Product productDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setSubcategory(productDto.getSubcategory());
        product.setCategory(productDto.getCategory());
        product.setDescription(productDto.getDescription());
        product.setImgUrl(productDto.getImgUrl());

        // 🔹 Mapear inventories si existen en el DTO
        if (productDto.getInventories() != null && !productDto.getInventories().isEmpty()) {
            Set<Inventory> inventories = new HashSet<>();

            for (InventoryDto invDto : productDto.getInventories()) {
                Inventory inv = new Inventory();
                inv.setQuantity(invDto.getQuantity());
                inv.setProductSize(invDto.getProductSize());
                inv.setProductPrice(invDto.getProductPrice());
                inv.setBarCode(invDto.getBarCode());
                
                // 🔹 IMPORTANTE: establecer relación bidireccional
                inv.setProduct(product);

                inventories.add(inv);
            }

            product.setInventories(inventories);
        }

        return product;
    }

    @Override
    public ProductDto update(Integer id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Product with id " + id + " not found"));

        existingProduct.setName(productDto.getName());
        existingProduct.setSubcategory(productDto.getSubcategory());
        existingProduct.setCategory(productDto.getCategory());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setImgUrl(productDto.getImgUrl());

        // Si llegan inventories nuevos, los actualizamos también
        if (productDto.getInventories() != null) {
            existingProduct.getInventories().clear();
            for (InventoryDto invDto : productDto.getInventories()) {
                Inventory inv = new Inventory();
                inv.setQuantity(invDto.getQuantity());
                inv.setProductSize(invDto.getProductSize());
                inv.setProductPrice(invDto.getProductPrice());
                inv.setBarCode(invDto.getBarCode());
                inv.setProduct(existingProduct);
                existingProduct.getInventories().add(inv);
            }
        }

        Product updatedProduct = productRepository.save(existingProduct);
        return productToProductDto(updatedProduct);
    }

    // 🔹 ELIMINAR PRODUCTO
    @Override
    public void deleteById(Integer id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Product with id " + id + " not found"));
        productRepository.delete(existingProduct);
    }

    @Override
    public Iterable<ProductDto> findAllByDescription(String description) {
        return null;
    }
}
