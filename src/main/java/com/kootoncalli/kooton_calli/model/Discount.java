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

    @Column(name = "discount_name", nullable = false) private String discountName;
    @Column(name="discount_amount", precision = 5, scale = 2) private BigDecimal discountAmount;
    @Column(name="discount_start_date", nullable = false) private LocalDate discountStartDate;
    @Column(name="discount_end_date", nullable = false) private LocalDate discountEndDate;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = true)
    private Product product; 
    
    public Discount() {}

   
    public Discount(Integer id, String discountName, BigDecimal discountAmount, LocalDate discountStartDate,
            LocalDate discountEndDate) {
        this.id = id;
        this.discountName = discountName;
        this.discountAmount = discountAmount;
        this.discountStartDate = discountStartDate;
        this.discountEndDate = discountEndDate;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
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
        builder.append(", discountName=");
        builder.append(discountName);
        builder.append(", discountAmount=");
        builder.append(discountAmount);
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
        result = prime * result + ((discountName == null) ? 0 : discountName.hashCode());
        result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
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
        if (discountName == null) {
            if (other.discountName != null)
                return false;
        } else if (!discountName.equals(other.discountName))
            return false;
        if (discountAmount == null) {
            if (other.discountAmount != null)
                return false;
        } else if (!discountAmount.equals(other.discountAmount))
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
