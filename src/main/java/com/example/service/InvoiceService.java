package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Invoice;

@Repository
public interface InvoiceService extends JpaRepository<Invoice, Long>{

}
