package com.fseproj.companyservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fseproj.companyservice.dto.StockPriceDto;

@FeignClient("stock-price-api")
public interface StockPriceClient {
	
	@PostMapping("/stockprice/stockprices/add")
	public void save(@RequestBody StockPriceDto stockPriceDto);

}
