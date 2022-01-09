package com.example.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 import org.springframework.stereotype.Repository;

import com.example.model.Product;


@Repository
public interface ProductService extends JpaRepository<Product, Integer>{

	@Query("SELECT p from Product p where p.pname like %?1% or p.cname like %?1%")
	List<Product> searchProducts(String searchText);
	
}
