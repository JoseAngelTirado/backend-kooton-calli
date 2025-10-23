package com.kootoncalli.kooton_calli.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
    @Column(name="product_name", length=50, nullable=false) private String name;
    @Column(name="subcategory", length = 50, nullable = false) private String subcategory;
    @Column(name="category", length = 50, nullable = false) private String category;
    @Column(name="description", length = 255, nullable = false) private String description;
    @Column(name="img_url", length = 255, nullable = false) private String imgUrl;

    //Relacion OneToMany para la relacion con llave foranea en la tabla SaleProduct
    @OneToMany(mappedBy = "product")
    private Set<SaleProduct> saleProducts;
    
    @OneToMany(mappedBy = "product")
    private Set<Discount> discounts = new HashSet<>();


    public Product() {}

    public Product(Integer id, String name, String subcategory, String category, String description, String imgUrl) {
        this.id = id;
        this.name = name;
        this.subcategory = subcategory;
        this.category = category;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Product [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", subcategory=");
        builder.append(subcategory);
        builder.append(", category=");
        builder.append(category);
        builder.append(", description=");
        builder.append(description);
        builder.append(", imgUrl=");
        builder.append(imgUrl);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((subcategory == null) ? 0 : subcategory.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
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
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (subcategory == null) {
            if (other.subcategory != null)
                return false;
        } else if (!subcategory.equals(other.subcategory))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (imgUrl == null) {
            if (other.imgUrl != null)
                return false;
        } else if (!imgUrl.equals(other.imgUrl))
            return false;
        return true;
    }
    
}
