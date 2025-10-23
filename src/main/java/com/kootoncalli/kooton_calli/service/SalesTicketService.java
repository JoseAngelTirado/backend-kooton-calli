package com.kootoncalli.kooton_calli.service;

import java.util.List;

import com.kootoncalli.kooton_calli.dto.SalesTicketDto;

public interface  SalesTicketService {
      // Crud Methods
    SalesTicketDto save(SalesTicketDto salesTicketDto);

    SalesTicketDto findById(Integer id);

    List<SalesTicketDto> findAll();

    SalesTicketDto updateSalesTicket(Integer id, SalesTicketDto salesTicketDto);

    void deleteById(Integer id);



}

