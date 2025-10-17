package com.kootoncalli.kooton_calli.repository;

import org.springframework.data.repository.CrudRepository;

import com.kootoncalli.kooton_calli.model.SalesTicket;

public interface SaleTicketRepository extends CrudRepository<SalesTicket, Integer> {

    //Devuelve todos los tickets de un cliente en espeecífico
    //Select * from sales_tickets where total_amount = (%?%)
    //Iterable<SalesTicket> findAllByTotalAmountContaining(Integer totalAmount);


}
