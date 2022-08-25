package com.fseproj.companyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceDto {
	
	private String id;
	private String companyCode;
	private String stockExchange;
	private double price;
	private String date;
	private String time;

}
