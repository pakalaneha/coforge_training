package com.coforge.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coforge.sms.model.Supplier;

import jakarta.validation.Valid;

public interface SupplierService {

	boolean saveSupplier(@Valid Supplier supplier);

	boolean updateSupplier(@Valid int supplierId, @Valid Supplier supplier);

	boolean deleteSupplier(@Valid int supplierId);

	Optional<Supplier> findSupplierById(@Valid int supplierId);

	List<Supplier> findAllSuppliers();

}
