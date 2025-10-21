package com.kootoncalli.kooton_calli.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="invetories") // Nota: Esto asume que el nombre de tu tabla es 'invetories' y no 'inventories'
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;

    // 🛑 CAMPO FK AGREGADO: Mapea la columna id_product
    @Column(name="id_product", nullable = false) 
    private Integer productId; 

    @Column(name="quantity")private Integer quantity;
    @Column(name="product_size", length = 3, nullable = false) private String productSize;
    @Column(name="product_price", nullable=false, precision = 10, scale = 2)private BigDecimal productPrice;
    @Column(name="bar_code", length = 14, nullable = false, unique= true) private String barCode;

    public Inventory() {}

    public Inventory(Integer id, Integer productId, Integer quantity, String productSize, BigDecimal productPrice, String barCode) {
        this.id = id;
        this.productId = productId; // Constructor actualizado
        this.quantity = quantity;
        this.productSize = productSize;
        this.productPrice = productPrice;
        this.barCode = barCode;
    }

    // --- Getters y Setters ---

    // Getter y Setter para el nuevo campo FK
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    // ... otros getters/setters (dejados fuera para brevedad) ...
    // Asegúrate de incluir todos los getters/setters y que el resto de tu código
    // (hashCode, equals, toString) también maneje el campo 'productId'.
    
    // El resto de tus getters/setters/métodos...
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getProductSize() { return productSize; }
    public void setProductSize(String productSize) { this.productSize = productSize; }
    public BigDecimal getProductPrice() { return productPrice; }
    public void setProductPrice(BigDecimal productPrice) { this.productPrice = productPrice; }
    public String getBarCode() { return barCode; }
    public void setBarCode(String barCode) { this.barCode = barCode; }

    @Override
    public String toString() {
        // ... (Tu implementación de toString) ...
        return "Inventory [id=" + id + ", productId=" + productId + ", ...]";
    }
    // ... (Tu implementación de hashCode y equals) ...
}