package com.kootoncalli.kooton_calli.dto;

import java.math.BigDecimal;

public class SaleProductDto {

    private Integer id;
    private Integer productsAmount;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;

    SaleProductDto(){

    }

    

    public SaleProductDto(Integer id, Integer productsAmount, BigDecimal unitPrice, BigDecimal subtotal) {
        this.id = id;
        this.productsAmount = productsAmount;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
        builder.append("SaleProduct [id=");
        builder.append(id);
        builder.append(", productsAmount=");
        builder.append(productsAmount);
        builder.append(", unitPrice=");
        builder.append(unitPrice);
        builder.append(", subtotal=");
        builder.append(subtotal);
        builder.append("]");
        return builder.toString();
    }

}
