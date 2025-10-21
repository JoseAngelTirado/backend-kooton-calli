package com.kootoncalli.kooton_calli.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.kootoncalli.kooton_calli.dto.SalesTicketDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "sales_tickets")
public class SalesTicket {

    @Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;

    @Column(name="total_amount", nullable=false, precision = 10, scale = 2)private BigDecimal totalAmount;
    @CreationTimestamp
    @Column(name = "date_time", nullable = false, updatable = false) private LocalDateTime dateTime;

    // Customer (buyer user)
    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_user")
    private User customer;

    // Employee (assisting user)
    @ManyToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "id_user")
    private User employee;
    

    public SalesTicket(){

    }

    public SalesTicket(Integer id, BigDecimal totalAmount, LocalDateTime dateTime) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Sales Ticket [id=");
        builder.append(id);
        builder.append(", totalAmount=");
        builder.append(totalAmount);
        builder.append(", dateTime=");
        builder.append(dateTime);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
        result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SalesTicket other = (SalesTicket) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (totalAmount == null) {
            if (other.totalAmount != null)
                return false;
        } else if (!totalAmount.equals(other.totalAmount))
            return false;
        if (dateTime == null) {
            if (other.dateTime != null)
                return false;
        } else if (!dateTime.equals(other.dateTime))
            return false;
        return true;
    }

    public void add(List<SalesTicketDto> salesTicketDto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
