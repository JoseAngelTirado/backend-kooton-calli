package com.kootoncalli.kooton_calli.dto;

import java.util.List;

public class ProductDto {

    private Integer id;
    private String name;
    private String subcategory;
    private String category;
    private String description;
    private String imgUrl;
    private List<InventoryDto> inventories;

    public ProductDto() {

    }
    
    public ProductDto(Integer id, String name, String subcategory, String category, 
                     String description, String imgUrl) {
        this.id = id;
        this.name = name;
        this.subcategory = subcategory;
        this.category = category;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public ProductDto(Integer id, String name, String subcategory, String category, String description, String imgUrl,
            List<InventoryDto> inventories) {
        this.id = id;
        this.name = name;
        this.subcategory = subcategory;
        this.category = category;
        this.description = description;
        this.imgUrl = imgUrl;
        this.inventories = inventories;
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

    public List<InventoryDto> getInventories() {
        return inventories;
    }

    public void setInventories(List<InventoryDto> inventories) {
        this.inventories = inventories;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TuClase [id=");
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
        builder.append(", inventories=");
        builder.append(inventories); // Esto llamará al toString() de la lista y sus elementos
        builder.append("]");
        return builder.toString();
    }

    
}
