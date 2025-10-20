package com.kootoncalli.kooton_calli.service.impl;

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


      private SalesTicket salesTicketToSalesTicket(SalesTicketDto salesTicketDto) {
            SalesTicket salesTicket = new SalesTicket();
            salesTicket.setId(salesTicketDto.getIdTicket());
            salesTicket.setTotalAmount(salesTicketDto.getTotalAmount()); 
            salesTicket.setDateTime(salesTicketDto.getDateTime());
            salesTicket.setIdCustomer(salesTicketDto.getIdCustomer());
            salesTicket.setIdEmployee(salesTicketDto.getIdEmployee());
            return salesTicket;
      }

      private SalesTicketDto salesTicketToSalesTicketDto(SalesTicket salesTicket) {
            SalesTicket salesTicket = new SalesTicket(
            salesTicket.setIdTicket(),
            salesTicket.setTotalAmount(), 
            salesTicket.setDateTime(),
            salesTicket.setIdCustomer(),
            salesTicket.setIdEmployee(),
            );
            return salesTicket;
      }

}