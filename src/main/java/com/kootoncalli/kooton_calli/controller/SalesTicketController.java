package com.kootoncalli.kooton_calli.controller;

import java.util.List;

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

    // Get all tickets
    @GetMapping
    ResponseEntity<List<SalesTicketDto>> getAllSalesTicket() {
        return ResponseEntity.ok(salesTicketService.findAll());
    }

    // Create new ticket
    @PostMapping
    ResponseEntity<SalesTicketDto> createdSalesTicket(@RequestBody SalesTicketDto salesTicketDto) {
        SalesTicketDto existingSalesTicketDto = salesTicketService.save(salesTicketDto);
        return ResponseEntity.ok(existingSalesTicketDto);
    }

    // Get ticket by id
    @GetMapping("/{id}")
    ResponseEntity<SalesTicketDto> findById(@PathVariable("id") Integer id) {
        SalesTicketDto existingSalesTicketDto = salesTicketService.findById(id);
        return ResponseEntity.ok(existingSalesTicketDto);
    }

    // Update by id
    @PutMapping("/{id}")
    ResponseEntity<SalesTicketDto> updateSalesTicketById(
            @PathVariable("id") Integer id,
            @RequestBody SalesTicketDto salesTicketDto) {
        SalesTicketDto existingSalesTicketDto = salesTicketService.updateSalesTicket(id, salesTicketDto);
        return ResponseEntity.ok(existingSalesTicketDto);
    }

    // Delete ticket
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        salesTicketService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
