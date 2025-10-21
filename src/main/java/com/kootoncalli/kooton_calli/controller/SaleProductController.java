package com.kootoncalli.kooton_calli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kootoncalli.kooton_calli.dto.SaleProductDto;
import com.kootoncalli.kooton_calli.service.SaleProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/saleproducts")
@CrossOrigin(origins = "*")
public class SaleProductController {

    private final SaleProductService saleProductService;

    public SaleProductController(SaleProductService saleProductService) {
        this.saleProductService = saleProductService;
    }

    @GetMapping
    ResponseEntity<Iterable<SaleProductDto>> getAllSaleProducts(){
        return ResponseEntity.ok(saleProductService.findAll());
    }

    @PostMapping
    ResponseEntity<SaleProductDto> createSaleProduct(@RequestBody SaleProductDto saleProductDto){
        SaleProductDto createdSaleProduct = saleProductService.save(saleProductDto);
        return ResponseEntity.status(201).body(createdSaleProduct);
    }

    @GetMapping("/{id}")
    ResponseEntity<SaleProductDto> getSaleProductBy(@PathVariable("id") Integer id){
        SaleProductDto saleProductDto = saleProductService.findById(id, id, null);
        return ResponseEntity.ok(saleProductDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<SaleProductDto> updateSaleProduct(
        @PathVariable("id") Integer id, 
        @RequestBody SaleProductDto saleProductDto
    ){
        SaleProductDto updateSaleProduct = saleProductService.update(id, id, saleProductDto);
        return ResponseEntity.ok(updateSaleProduct);
    }
    
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteSaleProduct(@PathVariable("id") Integer id){
        saleProductService.deleteByID(id, id);
        return ResponseEntity.noContent().build();
    }
    
}
