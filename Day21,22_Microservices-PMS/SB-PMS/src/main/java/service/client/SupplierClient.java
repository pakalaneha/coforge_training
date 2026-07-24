package com.coforge.pms.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coforge.pms.dto.SupplierDTO;

@FeignClient(name = "SB-SMS-SERVICE", path = "/api/v1/sms")
public interface SupplierClient {

	@GetMapping("/suppliers/{supplierId}")
	public SupplierDTO findSupplierById(@PathVariable("supplierId") int supplierId);
	
	@GetMapping("/suppliers")
	public List<SupplierDTO> findAllSuppliers();
	
}
