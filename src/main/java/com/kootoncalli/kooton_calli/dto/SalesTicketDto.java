package com.kootoncalli.kooton_calli.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SalesTicketDto {
	private Integer idTicket;
	private BigDecimal totalAmount;
	private LocalDateTime dateTime;
	private Integer idCustomer;
	private Integer idEmployee;
	
	// Empty constructor
	public SalesTicketDto() {
	
	}
	
	// Constructor with fields
	public SalesTicketDto(Integer idTicket, BigDecimal totalAmount, LocalDateTime dateTime, Integer idCustomer,
			Integer idEmployee) {
		this.idTicket = idTicket;
		this.totalAmount = totalAmount;
		this.dateTime = dateTime;
		this.idCustomer = idCustomer;
		this.idEmployee = idEmployee;
	}
	
	// Getters and setters
	public Integer getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
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

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Integer getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}
	
	// ToString
	@Override
	public String toString() {
	StringBuilder builder = new StringBuilder();
		builder.append("SalesTicket [idTicket=");
		builder.append(idTicket);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", idCustomer=");
		builder.append(idCustomer);
		builder.append(", idEmployee=");
		builder.append(idEmployee);
		builder.append("]");
		return builder.toString();
	}
}