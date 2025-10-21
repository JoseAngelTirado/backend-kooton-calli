package com.kootoncalli.kooton_calli.service;

import com.kootoncalli.kooton_calli.dto.SalesTicketDto;

public interface  SalesTicketService {
      // Crud Methods
      SalesTicketDto save(SalesTicketDto salesTicketDto);
      SalesTicketDto findById(Integer id);

      Iterable<SalesTicketDto> findAll();
      SalesTicketDto update(Integer idSaleTicket, SalesTicketDto salesTicketDto);

      public SalesTicketDto getSaleTicketById(Integer id);
      void deleteById(Integer id);
      void deleteByID(Integer id);
}
