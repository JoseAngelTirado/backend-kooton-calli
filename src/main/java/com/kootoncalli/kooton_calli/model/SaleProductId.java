package com.kootoncalli.kooton_calli.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


/**
 * @Embeddable
 * Indica que una clase puede ser incrustada (embed) en otra entidad.
 * No es una entidad independiente (no tiene su propia tabla)
 * Sus campos se mapean a columnas en la tabla de la entidad que lo contiene
 */
@Embeddable
public class SaleProductId implements Serializable{

    @Column
    (name="id_ticket") private Integer idTicket;

    @Column
    (name="id_prodcut") private Integer idProduct;


    SaleProductId(){

    }


    public SaleProductId(Integer idTicket, Integer idProduct) {
        this.idTicket = idTicket;
        this.idProduct = idProduct;
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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTicket == null) ? 0 : idTicket.hashCode());
        result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
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
        SaleProductId other = (SaleProductId) obj;
        if (idTicket == null) {
            if (other.idTicket != null)
                return false;
        } else if (!idTicket.equals(other.idTicket))
            return false;
        if (idProduct == null) {
            if (other.idProduct != null)
                return false;
        } else if (!idProduct.equals(other.idProduct))
            return false;
        return true;
    }

}
