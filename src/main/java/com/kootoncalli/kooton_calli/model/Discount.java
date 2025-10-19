package com.kootoncalli.kooton_calli.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="discounts")
public class Discount {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;

    @Column(name="discount_amount", precision = 10, scale = 2) private BigDecimal discountAmoount;
    @Column(name="discount_start_date", nullable = false) private LocalDate discountStartDate;
    @Column(name="discount_end_date", nullable = false) private LocalDate discountEndDate;

    @ManyToOne
    @JoinColumn(name = "id_product, nullable = true")
    private Discount discount; 
    
    public Discount() {}

    public Discount(Integer id, BigDecimal discountAmoount, LocalDate discountStartDate, LocalDate discountEndDate) {
        this.id = id;
        this.discountAmoount = discountAmoount;
        this.discountStartDate = discountStartDate;
        this.discountEndDate = discountEndDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getDiscountAmoount() {
        return discountAmoount;
    }

    public void setDiscountAmoount(BigDecimal discountAmoount) {
        this.discountAmoount = discountAmoount;
    }

    public LocalDate getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(LocalDate discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public LocalDate getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(LocalDate discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Discount [id=");
        builder.append(id);
        builder.append(", discountAmount=");
        builder.append(discountAmoount);
        builder.append(", discountStartDate=");
        builder.append(discountStartDate);
        builder.append(", discountEndDate=");
        builder.append(discountEndDate);
        builder.append("]");
        return builder.toString();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((discountAmoount == null) ? 0 : discountAmoount.hashCode());
        result = prime * result + ((discountStartDate == null) ? 0 : discountStartDate.hashCode());
        result = prime * result + ((discountEndDate == null) ? 0 : discountEndDate.hashCode());
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
        Discount other = (Discount) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (discountAmoount == null) {
            if (other.discountAmoount != null)
                return false;
        } else if (!discountAmoount.equals(other.discountAmoount))
            return false;
        if (discountStartDate == null) {
            if (other.discountStartDate != null)
                return false;
        } else if (!discountStartDate.equals(other.discountStartDate))
            return false;
        if (discountEndDate == null) {
            if (other.discountEndDate != null)
                return false;
        } else if (!discountEndDate.equals(other.discountEndDate))
            return false;
        return true;
    }


    

}
