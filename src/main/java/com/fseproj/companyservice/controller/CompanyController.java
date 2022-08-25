package com.fseproj.companyservice.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fseproj.companyservice.dto.CompanyDto;
import com.fseproj.companyservice.dto.StockPriceDto;
import com.fseproj.companyservice.exception.CompanyNotFoundException;
import com.fseproj.companyservice.service.CompanyService;

@RestController
@RequestMapping("api/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService compService;
	
	@GetMapping(path = "")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<CompanyDto>> getAllCompanies() {

		return ResponseEntity.ok(compService.getAllCompanies());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<CompanyDto> getCompany(@PathVariable String id) throws CompanyNotFoundException {
		
		CompanyDto companyDto = compService.findById(id);
		if(companyDto == null)
			throw new CompanyNotFoundException("Company Not found with id : " + id);
		return ResponseEntity.ok(companyDto);
	}
	
	@GetMapping(path = "/match/{pattern}")
	public ResponseEntity<List<CompanyDto>> getMatchingCompanies(@PathVariable String pattern) {
		
		return ResponseEntity.ok(compService.getMatchingCompanies(pattern));
	}
	
	@GetMapping(path = "/{id}/stockprices")
	public ResponseEntity<List<StockPriceDto>> getStockPrices(@PathVariable String id) throws CompanyNotFoundException {
		
		List<StockPriceDto> stockPriceDtos = compService.getStockPrices(id);
		if(stockPriceDtos == null)
			throw new CompanyNotFoundException("company not found for Id : " + id);
		return ResponseEntity.ok(stockPriceDtos);
	}
	
	@PostMapping(path = "")
	public ResponseEntity<?> addCompany(@RequestBody CompanyDto companyDto) {
		
		return ResponseEntity.ok(compService.addCompany(companyDto));
	}
	
	@PutMapping(path = "")
	public ResponseEntity<CompanyDto> editCompany(@RequestBody CompanyDto companyDto) throws CompanyNotFoundException {
		
		CompanyDto updatedCompanyDto = compService.editCompany(companyDto);
		if(updatedCompanyDto == null) 
			throw new CompanyNotFoundException("company not found with id : " + companyDto.getId());
		return ResponseEntity.ok(updatedCompanyDto);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteCompany(@PathVariable String id) {
		
		compService.deleteCompany(id);
	}
	
	@PostMapping(path = "/{companyCode}/stockprices")
	public ResponseEntity<CompanyDto> addStockPriceToCompany(@PathVariable String companyCode, @RequestBody StockPriceDto stockPriceDto) throws CompanyNotFoundException {
		
		CompanyDto companyDto = compService.addStockPriceToCompany(companyCode, stockPriceDto);
		if(companyDto == null)
			throw new CompanyNotFoundException("company not found for code : " + companyCode);
		return ResponseEntity.ok(companyDto);
	}

}
