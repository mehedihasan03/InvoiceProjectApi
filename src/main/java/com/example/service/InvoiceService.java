package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Invoice;

@Repository
public interface InvoiceService extends JpaRepository<Invoice, Long>{
	
	@Query("select sum(e.totalPrice) from Invoice e where year(e.paymentDate) = year(current_date) and  month(e.paymentDate) = month(current_date)")
	long getAllOfCurrentMonth();

}
