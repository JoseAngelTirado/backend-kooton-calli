package com.kootoncalli.kooton_calli.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DiscountDto {

    private Integer id;
    private String discountName;
    private BigDecimal discountAmount;
    private LocalDate discountStartDate;
    private LocalDate discountEndDate;

    public DiscountDto(){}

    public DiscountDto(Integer id, String discountName, BigDecimal discountAmount, LocalDate discountStartDate,
            LocalDate discountEndDate) {
        this.id = id;
        this.discountName = discountName;
        this.discountAmount = discountAmount;
        this.discountStartDate = discountStartDate;
        this.discountEndDate = discountEndDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDiscountName() {
        return discountName;
    }


    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }


    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }


    public LocalDate getDiscountStartDate() {
        return discountStartDate;
    }


    public void setDiscountStartDate(LocalDate discountStartDate) {
        this.discountStartDate = discountStartDate;
    }


    public LocalDate getDiscountEndDate() {
        return discountEndDate;
    }


    public void setDiscountEndDate(LocalDate discountEndDate) {
        this.discountEndDate = discountEndDate;
    }


    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
    builder.append("DiscountDto [id=");
    builder.append(id);
    builder.append(", discountName=");
    builder.append(discountName);
    builder.append(", discountAmount=");
    builder.append(discountAmount);
    builder.append(", discountStartDate=");
    builder.append(discountStartDate);
    builder.append(", discountEndDate=");
    builder.append(discountEndDate);
    builder.append("]");
    return builder.toString();
}

  


}
