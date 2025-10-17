package com.kootoncalli.kooton_calli.dto;

public class ProductDto {

    private Integer id;
    private String name;
    private String subcategory;
    private String category;
    private String description;

    public ProductDto() {

    }

    public ProductDto(Integer id, String name, String subcategory, String category, String description) {
        this.id = id;
        this.name = name;
        this.subcategory = subcategory;
        this.category = category;
        this.description = description;
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
        builder.append("]");
        return builder.toString();
    }
}
