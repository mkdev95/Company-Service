package com.fseproj.companyservice.service;

import java.util.List;

import com.fseproj.companyservice.dto.CompanyDto;
import com.fseproj.companyservice.dto.StockPriceDto;

public interface CompanyService {
	public List<CompanyDto> getAllCompanies();
	public CompanyDto findById(String id);
	public List<CompanyDto> getMatchingCompanies(String pattern);
	public CompanyDto addCompany(CompanyDto companyDto);
	public CompanyDto editCompany(CompanyDto companyDto);
	public void deleteCompany(String id);
	public CompanyDto addStockPriceToCompany(String companyCode, StockPriceDto stockPriceDto);
	public List<StockPriceDto> getStockPrices(String id);

}