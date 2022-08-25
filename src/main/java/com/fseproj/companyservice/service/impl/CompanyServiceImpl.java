package com.fseproj.companyservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fseproj.companyservice.dao.CompanyRepository;
import com.fseproj.companyservice.dto.CompanyDto;
import com.fseproj.companyservice.dto.StockPriceDto;
import com.fseproj.companyservice.feignclient.StockPriceClient;
import com.fseproj.companyservice.mapper.CompanyMapper;
import com.fseproj.companyservice.mapper.StockPriceMapper;
import com.fseproj.companyservice.model.Company;
import com.fseproj.companyservice.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository compRepo;
	
	@Autowired
	private CompanyMapper mapper;
	
	@Autowired
	private StockPriceMapper stockPriceMapper;
	
	@Autowired
	private StockPriceClient stockPriceClient;
	
	@Override
	public List<CompanyDto> getAllCompanies(){

		List<Company> companies = compRepo.findAll();
		return mapper.toCompanyDtos(companies);
	}

	@Override
	public CompanyDto findById(String id) {

		Optional<Company> company = compRepo.findById(id);
		if(!company.isPresent())
			return null;
		return mapper.toCompanyDto(company.get());
	}

	@Override
	public List<CompanyDto> getMatchingCompanies(String pattern) {
		// TODO Auto-generated method stub
		List<Company> companies = compRepo.findByNameIgnoreCaseContaining(pattern);
		return mapper.toCompanyDtos(companies);
	}

	@Override
	public CompanyDto addCompany(CompanyDto companyDto) {
		// TODO Auto-generated method stub
		Company company = mapper.toCompany(companyDto);
		company = compRepo.save(company);
		companyDto = mapper.toCompanyDto(company);
		//add stock exchange details
		return companyDto;
	}

	@Override
	public CompanyDto editCompany(CompanyDto companyDto) {
		// TODO Auto-generated method stub
		if(findById(companyDto.getId()) == null)
			return null;
		Company updatedCompany = compRepo.save(mapper.toCompany(companyDto));
		return mapper.toCompanyDto(updatedCompany);
	}

	@Override
	public void deleteCompany(String id) {
		// TODO Auto-generated method stub
		compRepo.deleteById(id);
	}

	@Override
	public CompanyDto addStockPriceToCompany(String companyCode, StockPriceDto stockPriceDto) {
		// TODO Auto-generated method stub
		Company company = compRepo.findByCode(companyCode);
		if(company == null)
			return null;
		company.getStockPrices().add(stockPriceMapper.toStockPrice(stockPriceDto));
		stockPriceClient.save(stockPriceDto);
		company = compRepo.save(company);
		return mapper.toCompanyDto(company);
	}

	@Override
	public List<StockPriceDto> getStockPrices(String id) {
		// TODO Auto-generated method stub
		Optional<Company> company = compRepo.findById(id);
		if(company == null)
			return null;
		return stockPriceMapper.toStockPriceDtos(company.get().getStockPrices());
	}

}
