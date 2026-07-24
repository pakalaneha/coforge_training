package com.coforge.sms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.sms.model.Supplier;
import com.coforge.sms.service.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/sms")
public class SupplierController {
	
	private SupplierService service;
	private Environment environment;
	
	@Autowired
	public SupplierController(SupplierService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}
	
	@PostMapping("/suppliers")
	public ResponseEntity<?> saveSupplier(@Valid @RequestBody Supplier supplier){
		ResponseEntity<?> responseEntity = null;
		
		boolean status = service.saveSupplier(supplier);
		if(status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("sms.save.success"),HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	@PutMapping("/suppliers/{supplierId}")
	public ResponseEntity<?> updateSupplier(@Valid @PathVariable int supplierId, @Valid @RequestBody Supplier supplier){
		ResponseEntity<?> responseEntity = null;
		
		boolean status = service.updateSupplier(supplierId, supplier);
		if(status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("sms.update.success"),HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/suppliers/{supplierId}")
	public ResponseEntity<?> deleteSupplier(@Valid @PathVariable int supplierId){
		ResponseEntity<?> responseEntity = null;
		
		boolean status = service.deleteSupplier(supplierId);
		if(status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("sms.delete.success"),HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/suppliers/{supplierId}")
	public ResponseEntity<?> findAllSuppliers(@Valid @PathVariable int supplierId){
		ResponseEntity<?> responseEntity = null;
		
		Optional<Supplier> supplier= service.findSupplierById(supplierId);
		if(!supplier.isEmpty()) {
			responseEntity = new ResponseEntity<>(supplier.get(),HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/suppliers")
	public ResponseEntity<?> findSupplier(){
		ResponseEntity<?> responseEntity = null;
		
		List<Supplier> suppliers = service.findAllSuppliers();
			responseEntity = new ResponseEntity<>(suppliers,HttpStatus.OK);
		return responseEntity;
	}
	
}
