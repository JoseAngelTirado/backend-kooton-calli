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

import com.kootoncalli.kooton_calli.dto.SalesTicketDto;
import com.kootoncalli.kooton_calli.service.SalesTicketService;

@RestController
@RequestMapping("/api/v1/salesticket")
@CrossOrigin(origins = "*")
public class SalesTicketController {
      private final SalesTicketService salesTicketService;
      
      // Injection by constructor (no autowired)
      public SalesTicketController(SalesTicketService salesTicketService) {
    	  this.salesTicketService = salesTicketService;
      } 

      // Get all tickets
      @GetMapping
      ResponseEntity<Iterable<SalesTicketDto>>getAllSalesTicket(){
            return ResponseEntity.ok(salesTicketService.findAll());
      }

      // Create new ticket
      @PostMapping
      ResponseEntity<SalesTicketDto>createdSalesTicket(@RequestBody SalesTicketDto salesTicketDto){
            SalesTicketDto exisitingSalesTicketDto = salesTicketService.save(salesTicketDto);
            return ResponseEntity.ok(exisitingSalesTicketDto);
      }

      // Get ticket by id
      @GetMapping("/{id}")
      ResponseEntity<SalesTicketDto> findById(@PathVariable("id") Integer id){
           SalesTicketDto existingSalesTicketDto = salesTicketService.findById(id);
           return ResponseEntity.ok(existingSalesTicketDto);
      }

      // Update by id
      @PutMapping("/{id}")
      ResponseEntity<SalesTicketDto> getSalesTicketById(
            @PathVariable("id") Integer id,
            @RequestBody SalesTicketDto salesTicketDto
      ){
            SalesTicketDto existingSalesTicketDto = salesTicketService.update(id, salesTicketDto);
            return ResponseEntity.ok(existingSalesTicketDto);
      }

      // Delete ticket
      @DeleteMapping("/{id}")
      ResponseEntity<Void> deleteById(@PathVariable("id")Integer id){
            salesTicketService.deleteById(id);
            return ResponseEntity.noContent().build();
      }
}
