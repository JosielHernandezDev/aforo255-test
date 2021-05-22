package com.AFORO255.MS.TEST.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class PayRedis implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id_operation;
	private Integer id_invoice;
	private double amount;
	private Timestamp date;
	public Integer getId_operation() {
		return id_operation;
	}
	public void setId_operation(Integer id_operation) {
		this.id_operation = id_operation;
	}
	public Integer getId_invoice() {
		return id_invoice;
	}
	public void setId_invoice(Integer id_invoice) {
		this.id_invoice = id_invoice;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
