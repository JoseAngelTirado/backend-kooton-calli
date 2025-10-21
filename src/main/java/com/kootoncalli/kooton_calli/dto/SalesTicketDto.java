package com.kootoncalli.kooton_calli.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SalesTicketDto {
	private Integer id;
	private BigDecimal totalAmount;
	private LocalDateTime dateTime;
	
	// Empty constructor
	public SalesTicketDto() {
	
	}
	
	// Constructor with fields
	public SalesTicketDto(Integer id, BigDecimal totalAmount, LocalDateTime dateTime) {
		this.id = id;
		this.totalAmount = totalAmount;
		this.dateTime = dateTime;

	}
	
	// Getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	// ToString
	@Override
	public String toString() {
	StringBuilder builder = new StringBuilder();
		builder.append("SalesTicket [id=");
		builder.append(id);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append("]");
		return builder.toString();
	}
}