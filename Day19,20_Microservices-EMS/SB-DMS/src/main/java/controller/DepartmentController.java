package com.coforge.dms.controller;

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

import com.coforge.dms.model.Department;
import com.coforge.dms.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/dms")
public class DepartmentController {

	private DepartmentService service;
	private Environment environment;

	@Autowired
	public DepartmentController(DepartmentService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/departments")
	public ResponseEntity<?> saveDept(@Valid @RequestBody Department department) {
		ResponseEntity<?> responseEntity = null;
		boolean status = service.saveDept(department);
		if (status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("dms.save.successInsert"), HttpStatus.OK);
		}

		return responseEntity;
	}

	@PutMapping("/departments/{dno}")
	public ResponseEntity<?> updateDeptById(@PathVariable("dno") int dno, @Valid @RequestBody Department department) {
		ResponseEntity<?> responseEntity = null;
		boolean status = service.updateDeptById(dno, department);
		if (status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("dms.save.successUpdate"), HttpStatus.OK);
		}

		return responseEntity;

	}

	@DeleteMapping("/departments/{dno}")
	public ResponseEntity<?> deleteDeptById(@PathVariable("dno") int dno) {
		ResponseEntity<?> responseEntity = null;
		boolean status = service.deleteDeptById(dno);
		if (status) {
			responseEntity = new ResponseEntity<>(environment.getProperty("dms.save.successDelete"), HttpStatus.OK);
		}

		return responseEntity;

	}

	@GetMapping("/departments/{dno}")
	public ResponseEntity<?> findDeptById(@PathVariable("dno") int dno) {
		ResponseEntity<?> responseEntity = null;
		Optional<Department> department = service.findDeptById(dno);
		if (department.get() != null) {
			responseEntity = new ResponseEntity<>(department.get(), HttpStatus.OK);
		}

		return responseEntity;

	}

	@GetMapping("/departments")
	public ResponseEntity<?> findDepts() {
		ResponseEntity<?> responseEntity = null;
		List<Department> department = service.findDepts();
		if (!department.isEmpty()) {
			responseEntity = new ResponseEntity<>(department, HttpStatus.OK);
		}

		return responseEntity;

	}

}
