package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Invoice;
import com.example.service.InvoiceService;

@RestController
@CrossOrigin(origins = "*")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	
	@GetMapping(value = "/invoice/search")
	public ResponseEntity<?> search(@RequestParam(value = "searchText") String searchText) {
		Map<String, Object> map = new HashMap<>();
		try {
			List<Invoice> invoice = invoiceService.searchInvoice(searchText);
			map.put("message", "Data get successfully");
			map.put("Data", invoice);
			map.put("Status code", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data fetch failed");
			map.put("Data", null);
			map.put("Status code", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	
	@PostMapping(value = "/invoice/save")
	public ResponseEntity<?> save(@RequestBody Invoice entity) {
		Map<String, Object> map = new HashMap<>();
		try {
			Invoice invoice = invoiceService.save(entity);
			map.put("message", "Data save successfully");
			map.put("Data", invoice);
			map.put("Status code", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data saved failed");
			map.put("Data", null);
			map.put("Status code", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	@GetMapping(value = "/invoice/getAll")
	public ResponseEntity<?> getInvoice() {
		Map<String, Object> map = new HashMap<>();
		try {
			List<Invoice> invoice =(List<Invoice>) invoiceService.findAll();
			map.put("message", "Data get successfully");
			map.put("Data", invoice);
			map.put("Status code", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data fetch failed");
			map.put("Data", null);
			map.put("Status code", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	@GetMapping(value = "/invoice/getLast10")
	public ResponseEntity<?> getLast10() {
		Map<String, Object> map = new HashMap<>();
		try {
			List<Invoice> invoice =(List<Invoice>) invoiceService.findTop10ByOrderByIdDesc();
			map.put("message", "Data get successfully");
			map.put("Data", invoice);
			map.put("Status code", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data fetch failed");
			map.put("Data", null);
			map.put("Status code", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	@GetMapping(value = "/invoice/current-sale")
	public ResponseEntity<?> getSalesOfCurrentMonth() {
		Map<String, Object> map = new HashMap<>();
		try {
			long totalSale = invoiceService.getAllOfCurrentMonth();
			map.put("message", "Data get successfully");
			map.put("Data", totalSale);
			map.put("Status code", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data fetch failed");
			map.put("Data", null);
			map.put("Status code", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	@GetMapping(value = "/invoice/count-invoice")
	public ResponseEntity<?> getcountInvoice() {
		Map<String, Object> map = new HashMap<>();
		try {
			long countInvoice = invoiceService.count();
			map.put("message", "Data get successfully");
			map.put("Data", countInvoice);
			map.put("Status code", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data fetch failed");
			map.put("Data", null);
			map.put("Status code", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	
	@GetMapping(value = "/invoice/count-today-invoices")
	public ResponseEntity<?> getcountTodayInvoices() {
		Map<String, Object> map = new HashMap<>();
		try {
			long countTodayInvoices = invoiceService.getCountTodayInvoices();
			map.put("message", "Data get successfully");
			map.put("Data", countTodayInvoices);
			map.put("Status code", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data fetch failed");
			map.put("Data", null);
			map.put("Status code", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	@GetMapping(value = "/invoice/count-daily-sale")
	public ResponseEntity<?> totalPrice() {
		Map<String, Object> map = new HashMap<>();
		try {
			long dailySale = invoiceService.getDailySale();
			map.put("message", "Data get successfully");
			map.put("Data", dailySale);
			map.put("Status code", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data fetch failed");
			map.put("Data", null);
			map.put("Status code", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
}
