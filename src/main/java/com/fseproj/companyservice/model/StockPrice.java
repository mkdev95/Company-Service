package com.fseproj.companyservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="stockprice")
public class StockPrice {
	
	@Id
	private String id;
	private String companyCode;
	private String stockExchange;
	private double price;
	private String date;
	private String time;
	public StockPrice(String companyCode, String stockExchange, double price, String date, String time) {
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.price = price;
		this.date = date;
		this.time = time;
	}
	
	

}
