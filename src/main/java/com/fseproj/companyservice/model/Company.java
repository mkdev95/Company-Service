package com.fseproj.companyservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Company")
@SuppressWarnings(value = { "unused" })
public class Company {
	@Id
	private String id;
	
	private String code;
	private String name;
	private String ceo;
	private String turnover;
	private String website;
	private String stockExchangeNames;
	
	@DBRef
	private List<StockPrice> stockPrices = new ArrayList<>();

	public Company(String code, String name, String ceo, String turnover, String website, String stockExchangeNames,
			List<StockPrice> stockPrices) {
		super();
		this.code = code;
		this.name = name;
		this.ceo = ceo;
		this.turnover = turnover;
		this.website = website;
		this.stockExchangeNames = stockExchangeNames;
		this.stockPrices = stockPrices;
	}

	public Company(String code, String name, String ceo, String turnover, String website, String stockExchangeNames) {
		super();
		this.code = code;
		this.name = name;
		this.ceo = ceo;
		this.turnover = turnover;
		this.website = website;
		this.stockExchangeNames = stockExchangeNames;
	}
	
	
	
}
