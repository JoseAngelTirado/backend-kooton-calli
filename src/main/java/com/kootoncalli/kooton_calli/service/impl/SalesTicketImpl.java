package com.kootoncalli.kooton_calli.service.impl;

import java.util.*;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kootoncalli.kooton_calli.dto.SalesTicketDto;
import com.kootoncalli.kooton_calli.model.SalesTicket;
import com.kootoncalli.kooton_calli.repository.SalesTicketRepository;
import com.kootoncalli.kooton_calli.service.SalesTicketService;


@Service
public class SalesTicketImpl implements SalesTicketService {
      
      private final SalesTicketRepository salesTicketRepository;

      public SalesTicketImpl(SalesTicketRepository salesTicketRepository){
            this.salesTicketRepository = salesTicketRepository;
      }

      @Override
      public SalesTicketDto save(SalesTicketDto salesTicketDto){
            salesTicketDto.setIdTicket(null);
            SalesTicket salesTicketToSave = salesTicketDtoToSalesTicket (salesTicketDto);
            SalesTicket createdSalesTicket = salesTicketRepository.save(salesTicketToSave);
      }


      private SalesTicket salesTicketDtoToSalesTicket(SalesTicketDto salesTicketDto) {
            SalesTicket salesTicket = new SalesTicket();
            salesTicket.setId(salesTicketDto.getIdTicket());
            salesTicket.setTotalAmount(salesTicketDto.getTotalAmount()); 
            salesTicket.setDateTime(salesTicketDto.getDateTime());
            salesTicket.setIdCustomer(salesTicketDto.getIdCustomer());
            salesTicket.setIdEmployee(salesTicketDto.getIdEmployee());
            return salesTicket;
      }

      private SalesTicketDto salesTicketToSalesTicketDto(SalesTicket salesTicket) {
            SalesTicketDto salesTicketDto = new SalesTicketDto(
            salesTicket.getId(),
            salesTicket.getTotalAmount(), 
            salesTicket.getDateTime(),
            salesTicket.getIdCustomer(),
            salesTicket.getIdEmployee()
            );
            return salesTicketDto;
      }

      @Override
      public SalesTicketDto findById(Integer id) {
        Optional<SalesTicket> salesTicketOptional = salesTicketRepository.findById(id);
        if(salesTicketOptional.isEmpty()){
            throw new IllegalStateException("The does not exist with id: " + id);
        }
        SalesTicket existingSalesTicket = salesTicketOptional.get();
        return salesTicketToSalesTicketDto(existingSalesTicket);
    }

    @Override
    public Iterable<SalesTicketDto> findAll() {
        List<SalesTicketDto> salesTicketDto = new ArrayList<>();
        Iterable<SalesTicket> salesTickets = salesTicketRepository.findAll();
        for(SalesTicket salesTicket: salesTickets){
            SalesTicketDto salesTicketDto = new SalesTicketDto(
            salesTicket.getId(), 
            salesTicket.getTotalAmount(), 
            salesTicket.getDateTime(), 
            salesTicket.getIdCustomer(), 
            salesTicket.getIdEmployee()
            );
            salesTicket.add(salesTicketDto);
        }
        return salesTicketDto;
    }

    @Override
    public SalesTicketDto update(Integer id, SalesTicketDto salesTicketDto) {
       Optional<SalesTicket> salesTicketOptional = salesTicketRepository.findById(id);
       if(salesTicketOptional.isEmpty()){
        throw new IllegalStateException("Sale Ticket does not exist with id: " + id);
       }
       SalesTicket existingSalesTicket = salesTicketOptional.get();
       SalesTicket newSalesTicket = salesTicketDtoToSalesTicket(salesTicketDto);

      existingSalesTicket.setTotalAmount(newSalesTicket.getTotalAmount());
      existingSalesTicket.setDateTime(newSalesTicket.getDateTime());

       
      return salesTicketToSalesTicketDto(salesTicketRepository.save(existingSalesTicket)); 
      }

      @Override
      public void deleteByID(Integer id) {
        Optional<SalesTicket> salesTicketOptional = salesTicketRepository.findById(id);
        if(salesTicketOptional.isEmpty()){
            throw new IllegalStateException("Sale Ticket does not exist with id: "+ id);
        }
        SalesTicket existingSalesTicket = salesTicketOptional.get();
        salesTicketRepository.delete(existingSalesTicket);
    }

    @Override
    public SalesTicketDto getSaleTicketById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}