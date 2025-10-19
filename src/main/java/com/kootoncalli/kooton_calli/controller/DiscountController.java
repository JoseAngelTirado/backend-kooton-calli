package com.kootoncalli.kooton_calli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.kootoncalli.kooton_calli.dto.DiscountDto;
import com.kootoncalli.kooton_calli.service.DiscountService;


@RestController
@RequestMapping("/api/v1/discounts")
@CrossOrigin(origins = "*")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    ResponseEntity<Iterable<DiscountDto>> getAllDiscounts(){
        return ResponseEntity.ok(discountService.findAll());
    }

   @PostMapping
    ResponseEntity<DiscountDto> createDiscount(@RequestBody DiscountDto discountDto){
    DiscountDto createdDiscount = discountService.save(discountDto);
    return ResponseEntity.status(201).body(createdDiscount);
    }
    
    @GetMapping("/{id}")
    ResponseEntity<DiscountDto> getDiscountByid(@PathVariable("id") Integer id){
        DiscountDto discountDto = discountService.findById(id);
        return ResponseEntity.ok(discountDto);
    }
    
    @PutMapping("/{id}")
    ResponseEntity<DiscountDto> updateDiscount(
        @PathVariable("id") Integer id,
        @RequestBody DiscountDto discountDto
    ){
        DiscountDto updatedDiscount = discountService.update(id,discountDto);
        return ResponseEntity.ok(updatedDiscount);
    }
    
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRole(@PathVariable("id") Integer id) {
        discountService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
}
