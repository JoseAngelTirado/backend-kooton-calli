package com.kootoncalli.kooton_calli.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="invetories") // Nota: Esto asume que el nombre de tu tabla es 'invetories' y no 'inventories'
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;

    
    @Column(name="id_product", nullable = false) 
    private Integer productId; 
    @Column(name="quantity")private Integer quantity;
    @Column(name="product_size", length = 3, nullable = false) private String productSize;
    @Column(name="product_price", nullable=false, precision = 10, scale = 2)private BigDecimal productPrice;
    @Column(name="bar_code", length = 14, nullable = false, unique= true) private String barCode;

    public Inventory() {

    }

    @ManyToOne
    @JoinColumn(name = "id_product",  nullable = false)
    private Product product;

    public Inventory(Integer id, Integer quantity, String productSize, BigDecimal productPrice, String barCode) {
        this.id = id;
        this.quantity = quantity;
        this.productSize = productSize;
        this.productPrice = productPrice;
        this.barCode = barCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Product [productId=");
        builder.append(productId);
        builder.append(", quantity=");
        builder.append(quantity);
        builder.append(", productSize=");
        builder.append(productSize);
        builder.append(", productPrice=");
        builder.append(productPrice);
        builder.append(", barCode=");
        builder.append(barCode);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        result = prime * result + ((productSize == null) ? 0 : productSize.hashCode());
        result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
        result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
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
        Inventory other = (Inventory) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        if (productSize == null) {
            if (other.productSize != null)
                return false;
        } else if (!productSize.equals(other.productSize))
            return false;
        if (productPrice == null) {
            if (other.productPrice != null)
                return false;
        } else if (!productPrice.equals(other.productPrice))
            return false;
        if (barCode == null) {
            if (other.barCode != null)
                return false;
        } else if (!barCode.equals(other.barCode))
            return false;
        return true;
    }
    
}