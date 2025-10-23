package com.kootoncalli.kooton_calli.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kootoncalli.kooton_calli.dto.SalesTicketDto;
import com.kootoncalli.kooton_calli.model.SalesTicket;
import com.kootoncalli.kooton_calli.repository.SalesTicketRepository;
import com.kootoncalli.kooton_calli.service.SalesTicketService;


@Service
public class SalesTicketImpl implements SalesTicketService {

    private final SalesTicketRepository salesTicketRepository;

    public SalesTicketImpl(SalesTicketRepository salesTicketRepository) {
        this.salesTicketRepository = salesTicketRepository;
    }

    @Override
    public SalesTicketDto save(SalesTicketDto salesTicketDto) {
        salesTicketDto.setId(null);
        SalesTicket salesTicketToSave = salesTicketDtoToSalesTicket(salesTicketDto);
        SalesTicket createdSalesTicket = salesTicketRepository.save(salesTicketToSave);
        return salesTicketToSalesTicketDto(createdSalesTicket);
    }

    @Override
    public SalesTicketDto findById(Integer id) {
        Optional<SalesTicket> salesTicketOptional = salesTicketRepository.findById(id);
        if (salesTicketOptional.isEmpty()) {
            throw new IllegalStateException("TheTicket  does not exist with id: " + id);
        }
        return salesTicketToSalesTicketDto(salesTicketOptional.get());
    }

    @Override
    public List<SalesTicketDto> findAll() {
        return ((List<SalesTicket>) salesTicketRepository.findAll())
            .stream()
            .map(this::salesTicketToSalesTicketDto)
            .toList(); // Java 16+ (o usa Collectors.toList() si estás en Java 11)
    }

    @Override
    public SalesTicketDto updateSalesTicket(Integer id, SalesTicketDto salesTicketDto) {
        SalesTicket existingSalesTicket = salesTicketRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("The Ticket does not exist with id: " + id));

        existingSalesTicket.setTotalAmount(salesTicketDto.getTotalAmount());
        existingSalesTicket.setDateTime(salesTicketDto.getDateTime());

        return salesTicketToSalesTicketDto(salesTicketRepository.save(existingSalesTicket));
    }

    @Override
    public void deleteById(Integer id) {
        SalesTicket existingSalesTicket = salesTicketRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("Sale Ticket does not exist with id: " + id));

        salesTicketRepository.delete(existingSalesTicket);
    }

    // Helpers para mapear entidades y DTOs
    private SalesTicket salesTicketDtoToSalesTicket(SalesTicketDto dto) {
        SalesTicket entity = new SalesTicket();
        entity.setId(dto.getId());
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setDateTime(dto.getDateTime());
        return entity;
    }

    private SalesTicketDto salesTicketToSalesTicketDto(SalesTicket entity) {
        return new SalesTicketDto(entity.getId(), entity.getTotalAmount(), entity.getDateTime());
    }
}