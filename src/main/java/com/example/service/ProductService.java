package com.example.service;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Product;



public interface ProductService extends CrudRepository<Product, Integer>{

}
