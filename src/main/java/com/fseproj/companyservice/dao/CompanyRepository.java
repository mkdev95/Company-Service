package com.fseproj.companyservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fseproj.companyservice.model.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {

	public Optional<Company> findById(String id);
	public List<Company> findByNameIgnoreCaseContaining(String pattern);
	public Company findByCode(String companyCode);
	public Company findByName(String name);

}
