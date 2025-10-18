package com.kootoncalli.kooton_calli.model;

import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="sale_products")
public class SaleProduct {

    /**
     * El id de que ser incrustado
     * Indica que la clave primaria de la entidad es una clase embebida que representa una clave compuesta.
     */
    @EmbeddedId
    private SaleProductId id;


    //Dos llaves foraneas componen a la lalve primaria en esta tabla SaleProduct
    //Declaracion de la llave foranea en la tabla SaleTicket
    @ManyToOne
    @MapsId("idTicket")
    @JoinColumn(name = "id_ticket")
    private SalesTicket saleTicket;


    //Declaracionc de la llave foranea en la tabla Product
    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "id_product")
    private Product product;


    @Column(name="products_amount", nullable = false) private Integer productsAmount;
    @Column(name="unit_price", nullable=false, precision = 10, scale = 2)private BigDecimal unitPrice;
    @Column(name="subtotal", nullable=false, precision = 10, scale = 2)private BigDecimal subtotal;


    //Constructor vacio
    public SaleProduct(){

    }

    //Constructor con campos
    public SaleProduct(SaleProductId id, SalesTicket saleTicket, Product product, Integer productsAmount,
            BigDecimal unitPrice, BigDecimal subtotal) {
        this.id = id;
        this.saleTicket = saleTicket;
        this.product = product;
        this.productsAmount = productsAmount;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public SaleProductId getId() {
            return id;
        }

        public void setId(SaleProductId id) {
            this.id = id;
        }

        public SalesTicket getSaleTicket() {
            return saleTicket;
        }

        public void setSaleTicket(SalesTicket saleTicket) {
            this.saleTicket = saleTicket;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
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


    //toStringBuilder
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SaleProduct [id=");
        builder.append(id);
        builder.append(", saleProduct=");
        builder.append(saleTicket != null ? saleTicket.getId() : null);
        builder.append(", product=");
        builder.append(product != null ? product.getId() : null);
        builder.append(", productsAmount=");
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((saleTicket == null) ? 0 : saleTicket.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (saleTicket == null) {
            if (other.saleTicket != null)
                return false;
        } else if (!saleTicket.equals(other.saleTicket))
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
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
