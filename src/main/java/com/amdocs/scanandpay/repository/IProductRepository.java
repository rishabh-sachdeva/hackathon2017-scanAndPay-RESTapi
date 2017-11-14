package com.amdocs.scanandpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.scanandpay.models.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{

	Product findByProductId(String productId);
}
