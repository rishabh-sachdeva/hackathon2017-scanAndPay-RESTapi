package com.amdocs.scanandpay;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amdocs.scanandpay.models.Product;
import com.amdocs.scanandpay.repository.IProductRepository;

@SpringBootApplication
public class ScanAndPayRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScanAndPayRestApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(IProductRepository repository) {
		return (args) -> {
			Product p = new Product();
			p.setName("p1");
			p.setProductId("123");
			p.setPrice(10.50);
			repository.save(p);
			
			Product p2 = new Product();
			p2.setName("p2");
			p2.setProductId("8901");
			p2.setPrice(30.33);
			repository.save(p2);
		};
	}
}
