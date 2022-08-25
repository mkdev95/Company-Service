package com.fseproj.companyservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.fseproj.companyservice.dao.CompanyRepository;
import com.fseproj.companyservice.model.Company;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner runner(CompanyRepository compRepo) {
//		return args -> {
////			List<StockPrice> stockPriceList = new ArrayList<>();
////			stockPriceList.add(new StockPrice("FC","exchange1",100,"19-06-2022","20:00"));
////			stockPriceList.add(new StockPrice("FC","exchange2",120,"18-06-2022","16:00"));
////			stockPriceList.add(new StockPrice("FC","exchange3",90,"13-06-2022","12:00"));
////			stockPriceList.add(new StockPrice("FC","exchange4",85,"11-06-2022","21:00"));
//			Company comp = new Company("FC","FirstCompany","Mukesh","100000","www.fc.com","sample,exchange,names");
//			compRepo.insert(comp);
//		};
//	}

}
