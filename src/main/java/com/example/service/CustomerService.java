package com.example.service;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Customer;

public interface CustomerService extends CrudRepository<Customer, Integer> {

}
