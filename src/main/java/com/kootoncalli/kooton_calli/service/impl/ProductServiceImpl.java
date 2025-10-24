package com.kootoncalli.kooton_calli.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            ProductDto productDto = productToProductDto(p);
            productsDto.add(productDto);
        }
        return productsDto;
    }

    @Override
    public ProductDto findById(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new IllegalStateException("Product with id " + id + " not found");
        }
        Product existingProduct = productOptional.get();
        return productToProductDto(existingProduct); 
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
        
        // AÑADE ESTA PARTE: Convertir los inventories
        if (product.getInventories() != null && !product.getInventories().isEmpty()) {
            List<InventoryDto> inventoryDtos = new ArrayList<>();
            
            for (Inventory inventory : product.getInventories()) {
                InventoryDto inventoryDto = convertInventoryToDto(inventory);
                inventoryDtos.add(inventoryDto);
            }
            
            productDto.setInventories(inventoryDtos);
        }
        
        return productDto;
    }

    // MÉTODO AUXILIAR PARA CONVERTIR INVENTORY A DTO
    private InventoryDto convertInventoryToDto(Inventory inventory) {
        InventoryDto inventoryDto = new InventoryDto();
        
        inventoryDto.setId(inventory.getId());
        inventoryDto.setQuantity(inventory.getQuantity());
        inventoryDto.setProductSize(inventory.getProductSize());
        inventoryDto.setProductPrice(inventory.getProductPrice());
        inventoryDto.setBarCode(inventory.getBarCode());
        
        if (inventory.getProduct() != null) {
            inventoryDto.setIdProduct(inventory.getProduct().getId());
        }
        
        return inventoryDto;
    }

    // LOS DEMÁS MÉTODOS PERMANECEN IGUAL (no los modifiques)
    @Override
    public ProductDto save(ProductDto productDto) {
        productDto.setId(null);
        Product productToSave = productDtoToProduct(productDto);
        Product createdProduct = productRepository.save(productToSave);
        return productToProductDto(createdProduct);
    }

    private Product productDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setSubcategory(productDto.getSubcategory());
        product.setCategory(productDto.getCategory());
        product.setDescription(productDto.getDescription());
        product.setImgUrl(productDto.getImgUrl());
        return product;
    }

    @Override
    public ProductDto update(Integer id, ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new IllegalStateException("Product with id " + id + " not found");
        }
        Product existingProduct = productOptional.get();

        Product newProduct = productDtoToProduct(productDto);
        existingProduct.setName(newProduct.getName());
        existingProduct.setSubcategory(newProduct.getSubcategory());
        existingProduct.setCategory(newProduct.getCategory());
        existingProduct.setDescription(newProduct.getDescription());
        existingProduct.setImgUrl(newProduct.getImgUrl());

        return productToProductDto(productRepository.save(existingProduct));
    }

    public void deleteById(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new IllegalStateException("Product with id " + id + " not found");
        }
        Product existingProduct = productOptional.get();
        productRepository.delete(existingProduct);
    }

    @Override
    public Iterable<ProductDto> findAllByDescription(String description) {
        return null;
    }
}
