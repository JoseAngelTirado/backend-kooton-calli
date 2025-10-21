package com.kootoncalli.kooton_calli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kootoncalli.kooton_calli.dto.SalesTicketDto;
import com.kootoncalli.kooton_calli.service.SalesTicketService;

@RestController
@RequestMapping("/api/v1/salesticket")
@CrossOrigin(origins = "*")
public class SalesTicketController {
      private final SalesTicketService salesTicketService;
      
      public SalesTicketController(SalesTicketService salesTicketService) {
    	  this.salesTicketService = salesTicketService;
      } 

      @GetMapping
      ResponseEntity<Iterable<SalesTicketDto>>getAllSalesTicket(){
            return ResponseEntity.ok(salesTicketService.findAll());
      }

      @PostMapping
      ResponseEntity<SalesTicketDto>createdSalesTicket(@RequestBody SalesTicketDto salesTicketDto){
            SalesTicketDto exisitingSalesTicketDto = salesTicketService.save(salesTicketDto);
            return ResponseEntity.ok(exisitingSalesTicketDto);
      }
      @GetMapping("/{id}")
      ResponseEntity<SalesTicketDto> findById(@PathVariable("id") Integer id){
           SalesTicketDto existingSalesTicketDto = salesTicketService.findById(id);
           return ResponseEntity.ok(existingSalesTicketDto);
      }

      @PutMapping("/{id}")
      ResponseEntity<SalesTicketDto> updateById(
            @PathVariable("id") Integer id,
            @RequestBody SalesTicketDto salesTicketDto
      ){
            SalesTicketDto existingSalesTicketDto = salesTicketService.update(id, salesTicketDto);
            return ResponseEntity.ok(existingSalesTicketDto);
      }

      @DeleteMapping("/{id}")
      ResponseEntity<Void> deleteById(@PathVariable("id")Integer id){
            salesTicketService.deleteById(id);
            return ResponseEntity.noContent().build();
      }
}
