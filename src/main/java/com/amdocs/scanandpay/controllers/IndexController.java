package com.amdocs.scanandpay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.scanandpay.models.Product;
import com.amdocs.scanandpay.repository.IProductRepository;

@CrossOrigin
@RestController
public class IndexController {

	@Autowired
	private IProductRepository productRepository;
	
	@GetMapping("/")
	public String get() {
		
		Product product = productRepository.findByProductId("123");
		
		if(product != null) {
			System.out.println(product.getName());
		}
		
		return "Hello";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") String id ) {
		Product product = productRepository.findByProductId(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	  @RequestMapping(value = "/add", method = RequestMethod.POST)		
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product insertedProduct = productRepository.save(product);
		return new ResponseEntity<>(insertedProduct, HttpStatus.CREATED);
	}
}
