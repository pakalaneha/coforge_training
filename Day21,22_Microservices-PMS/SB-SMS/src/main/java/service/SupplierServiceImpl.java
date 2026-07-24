package com.coforge.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.sms.exception.SupplierNotFoundException;
import com.coforge.sms.model.Supplier;
import com.coforge.sms.repo.SupplierRepo;

import jakarta.validation.Valid;

@Service
public class SupplierServiceImpl implements SupplierService{

	private SupplierRepo repo;
	private Environment environment;
	
	@Autowired
	public SupplierServiceImpl(SupplierRepo repo, Environment environment) {
		super();
		this.repo = repo;
		this.environment = environment;
	}
	@Override
	public boolean saveSupplier(@Valid Supplier supplier) {
		repo.save(supplier);
		return true;
	}
	@Override
	public boolean deleteSupplier(@Valid int supplierId) {
		if(!repo.existsById(supplierId)) 
			throw new SupplierNotFoundException(environment.getProperty("sms.invalid.not-found"));
		repo.deleteById(supplierId);
		return true;
	}
	@Override
	public Optional<Supplier> findSupplierById(@Valid int supplierId){
		if(!repo.existsById(supplierId)) 
			throw new SupplierNotFoundException(environment.getProperty("sms.invalid.not-found"));
		Optional<Supplier> supplier = repo.findById(supplierId);
		return supplier;
	}
	@Override
	public List<Supplier> findAllSuppliers() {
		List<Supplier> suppliers = (List<Supplier>) repo.findAll();
		return suppliers;
	}
	@Override
	public boolean updateSupplier(@Valid int supplierId, @Valid Supplier supplier) {
		if(!repo.existsById(supplierId)) 
		throw new SupplierNotFoundException(environment.getProperty("sms.update.success"));
		repo.save(supplier);
		return true;
	}

}
