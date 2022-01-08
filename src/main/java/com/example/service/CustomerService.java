package com.example.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

@Repository
public interface CustomerService extends CrudRepository<Customer, Integer> {

	@Query("SELECT c from Customer c where c.name like %?1% or c.phone like %?1%")
	List<Customer> searchCustomer(String searchText);
}
