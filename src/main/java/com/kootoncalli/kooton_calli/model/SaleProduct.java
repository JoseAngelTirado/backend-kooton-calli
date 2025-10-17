package com.kootoncalli.kooton_calli.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="sale_products")
public class SaleProduct {

    @Column(name="products_amount", nullable = false) private Integer productsAmount;
    @Column(name="unit_price", nullable=false, precision = 10, scale = 2)private BigDecimal unitPrice;
    @Column(name="subtotal", nullable=false, precision = 10, scale = 2)private BigDecimal subtotal;


    public SaleProduct(){

    }


    public SaleProduct(Integer productsAmount, BigDecimal unitPrice, BigDecimal subtotal) {
        this.productsAmount = productsAmount;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }


    public Integer getProductsAmount() {
        return productsAmount;
    }


    public void setProductsAmount(Integer productsAmount) {
        this.productsAmount = productsAmount;
    }


    public BigDecimal getUnitPrice() {
        return unitPrice;
    }


    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }


    public BigDecimal getSubtotal() {
        return subtotal;
    }


    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Sale Product [productsAmount=");
        builder.append(productsAmount);
        builder.append(", unitPrice=");
        builder.append(unitPrice);
        builder.append(", subtotal=");
        builder.append(subtotal);
        builder.append("]");
        return builder.toString();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productsAmount == null) ? 0 : productsAmount.hashCode());
        result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
        result = prime * result + ((subtotal == null) ? 0 : subtotal.hashCode());
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
        SaleProduct other = (SaleProduct) obj;
        if (productsAmount == null) {
            if (other.productsAmount != null)
                return false;
        } else if (!productsAmount.equals(other.productsAmount))
            return false;
        if (unitPrice == null) {
            if (other.unitPrice != null)
                return false;
        } else if (!unitPrice.equals(other.unitPrice))
            return false;
        if (subtotal == null) {
            if (other.subtotal != null)
                return false;
        } else if (!subtotal.equals(other.subtotal))
            return false;
        return true;
    }

    



}
