package com.coforge.ems.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coforge.ems.dto.DepartmentDTO;

@FeignClient(name = "SB-DMS-SERVICE", path = "/api/v1/dms") //enabling the request to 
public interface DepartmentClient {
	
	@GetMapping("/departments/{dno}") //url from departmentcontroller
	public DepartmentDTO findDepartmentById(@PathVariable("dno") int dno);

	@GetMapping("/departments")
	public List<DepartmentDTO> findAllDepartments();
}
