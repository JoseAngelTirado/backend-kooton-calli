package com.kootoncalli.kooton_calli.repository;

import org.springframework.data.repository.CrudRepository; // Importa BigDecimal para el tipo correcto

import com.kootoncalli.kooton_calli.model.SalesTicket;

public interface SalesTicketRepository extends CrudRepository<SalesTicket, Integer> {

    // --- CORRECCIÓN DEL MÉTODO ---
    
    // Si tu intención era buscar todos los tickets con una CANTIDAD TOTAL EXACTA:
    // El método correcto es 'findAllByTotalAmount' y el tipo de dato debe ser BigDecimal.
    // Consulta SQL: SELECT * FROM sales_tickets WHERE total_amount = ?
    // List<SalesTicket> findAllByTotalAmount(BigDecimal totalAmount);
    
    
    // --- OTRAS OPCIONES COMUNES ---
    
    // Si quieres buscar tickets con un total mayor a un monto:
    // List<SalesTicket> findAllByTotalAmountGreaterThan(BigDecimal totalAmount);

    // Si quieres buscar tickets de un cliente específico (asumiendo que hay un campo 'customer' en SalesTicket):
    // List<SalesTicket> findAllByCustomer_Id(Integer customerId); 
}