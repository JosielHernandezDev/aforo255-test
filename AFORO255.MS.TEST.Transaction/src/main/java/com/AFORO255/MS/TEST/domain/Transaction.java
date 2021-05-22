package com.AFORO255.MS.TEST.domain;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaction")
public class Transaction  {
	
	@BsonId
	private String id_transaction;
	private int id_invoice;
	private double amount ;
	private String date;
	
	public String getId_transaction() {
		return id_transaction;
	}
	public void setId_transaction(String id_transaction) {
		this.id_transaction = id_transaction;
	}
	public int getId_invoice() {
		return id_invoice;
	}
	public void setId_invoice(int id_invoice) {
		this.id_invoice = id_invoice;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}