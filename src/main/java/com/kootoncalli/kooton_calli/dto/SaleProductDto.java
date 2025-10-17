package com.kootoncalli.kooton_calli.dto;

import java.math.BigDecimal;

public class SaleProductDto {

    private Integer idTicket;
    private Integer idProduct;
    private Integer productsAmount;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;

    public SaleProductDto(Integer idTicket, Integer idProduct, Integer productsAmount, BigDecimal unitPrice,
            BigDecimal subtotal) {
        this.idTicket = idTicket;
        this.idProduct = idProduct;
        this.productsAmount = productsAmount;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
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
        builder.append("Sale Product [idTicket=");
        builder.append(idTicket);
        builder.append(", idProduct=");
        builder.append(idProduct);
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
