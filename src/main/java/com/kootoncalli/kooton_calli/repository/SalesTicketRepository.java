package com.kootoncalli.kooton_calli.repository;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

import com.kootoncalli.kooton_calli.model.SalesTicket;

public interface SalesTicketRepository extends CrudRepository<SalesTicket, Integer> {
    Iterable<SalesTicket> findAllByDateTime(LocalDateTime dateTime);
}