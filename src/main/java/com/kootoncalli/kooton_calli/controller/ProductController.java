package com.kootoncalli.kooton_calli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kootoncalli.kooton_calli.dto.ProductDto;
import com.kootoncalli.kooton_calli.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //@GetMapping handles HTTP GET requests to the route specified in @RequestMapping  
    //getAllProducts returns a ResponseEntity containing a list of ProductDto objects retrieved from the productService  
    //RESULT: when making a GET request to /api/v1/products, the client receives a 200 status and a JSON with all the products
    @GetMapping
    ResponseEntity<Iterable<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    //Handles HTTP POST requests to the route specified in @RequestMapping  
    //@RequestBody indicates that the HTTP request body should be converted into a ProductDto object  
    //productService.save(productDto) saves the new product and returns the created ProductDto  
    //RESULT: when making a POST request to /api/v1/products with a product JSON, the client receives a 201 status and a JSON with the created product
    @PostMapping
    ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto createdProduct = productService.save(productDto);
        return ResponseEntity.status(201).body(createdProduct);
    }

    //Handles HTTP GET requests to the /{id} route specified in @RequestMapping  
    //@PathVariable("id") indicates that the path variable {id} should be assigned to the id parameter  
    //productService.findById(id) searches for the product by its ID and returns the corresponding ProductDto  
    //RESULT: when making a GET request to /api/v1/products/{id}, the client receives a 200 status and a JSON with the product that matches the given ID
    @GetMapping("/{id}")
    ResponseEntity<ProductDto> findById(@PathVariable("id") Integer id) {
        ProductDto existingProductDto = productService.findById(id);
        return ResponseEntity.ok(existingProductDto);
    }

    //Handles HTTP PUT requests to the /{id} route specified in @RequestMapping  
    //@PathVariable("id") indicates that the path variable {id} should be assigned to the id parameter  
    //@RequestBody indicates that the HTTP request body should be converted into a ProductDto object  
    //productService.update(id, productDto) updates the product with the given ID and returns the updated ProductDto  
    //RESULT: when making a PUT request to /api/v1/products/{id} with a product JSON, the client receives a 200 status and a JSON with the updated product
    @PutMapping("/{id}")
    ResponseEntity<ProductDto> updateById(
        @PathVariable("id")Integer id,
        @RequestBody ProductDto productDto      
    ) {
        ProductDto existingProductDto = productService.update(id, productDto);
        return ResponseEntity.ok(existingProductDto);
    }

    //Handles HTTP DELETE requests to the /{id} route specified in @RequestMapping  
    //@PathVariable("id") indicates that the path variable {id} should be assigned to the id parameter  
    //productService.deleteById(id) deletes the product with the given ID  
    //ResponseEntity.noContent().build() returns an HTTP response with status 204 No Content (standard response when the deletion is successful and there’s no body to return)  
    //RESULT: when making a DELETE request to /api/v1/products/{id}, the client receives a 204 No Content status, meaning the product was successfully deleted
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id")Integer id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
