package com.kootoncalli.kooton_calli.service.impl;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kootoncalli.kooton_calli.dto.ProductDto;

import com.kootoncalli.kooton_calli.model.Product;
import com.kootoncalli.kooton_calli.repository.ProductRepository;
import com.kootoncalli.kooton_calli.service.ProductService;



@Service 
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //SAVE Method
    @Override
    public ProductDto save(ProductDto productDto) {
        productDto.setId(null);//Asegurarse que el id sea nulo para que se cree uno nuevo
        Product productToSave = productDtoToProduct(productDto);
        Product createdProduct = productRepository.save(productToSave);
        return productToProductDto(createdProduct);
    }

    //Auxiliary method to convert from ProductDto to Product
    private Product productDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setSubcategory(productDto.getSubcategory());
        product.setCategory(productDto.getCategory());
        product.setDescription(productDto.getDescription());
        return product;
    }

    //Auxiliary method to convert from Product to ProductDto
    private ProductDto productToProductDto(Product product) {
        ProductDto productDto = new ProductDto (
            product.getId(),
            product.getName(),
            product.getSubcategory(),
            product.getCategory(),
            product.getDescription()
        );
        return productDto;
    }

    //If the product does not exist, throw an exception  
    //If the product exists, get the entity using get() and convert it to a DTO using productToProductDto  
    //Return the found ProductDto
    @Override
    public ProductDto findById(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new IllegalStateException("Product with id " + id + " not found");
        }
        Product existingProduct = productOptional.get();
        return productToProductDto(existingProduct);
    }

    //findAll method
    //Retrieves all products and converts them to DTOs:  
    // - Creates an empty list of ProductDto  
    // - Calls productRepository.findAll() to get all products  
    // - Iterates over each Product, converts it to ProductDto, and adds it to the list  
    // - Returns the list of DTOs (as Iterable<ProductDto>)
    @Override
    public Iterable<ProductDto> findAll() {
        List<ProductDto> productsDto = new ArrayList<>();
        Iterable<Product> product = productRepository.findAll();
        for (Product p : product) {
            ProductDto productDto = new ProductDto(p.getId(), p.getName(), p.getSubcategory(), p.getCategory(), p.getDescription());
            productsDto.add(productDto);
        }
        return productsDto;
    }
    
    //update method
    //Updates an existing product:  
    // - Searches for the product by id. If it does not exist, throws an exception  
    // - Creates a new Product from the received ProductDto  
    // - Updates the existing product’s fields with the new product’s values  
    // - Saves the updated product in the repository  
    // - Converts the saved product to ProductDto and returns it
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

        return productToProductDto(productRepository.save(existingProduct));
    }

    //deletdById method
    //Deletes a product by id:  
    // - Searches for the product by id. If it does not exist, throws an exception  
    // - If it exists, deletes it from the repository
    public void deleteById(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new IllegalStateException("Product with id " + id + " not found");
        }
        Product existingProduct = productOptional.get();

        //Borrado real
        productRepository.delete(existingProduct);
    }

    @Override
    public Iterable<ProductDto> findAllByDescription(String description) {
        return null;
    }
    
}
