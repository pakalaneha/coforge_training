package com.coforge.dms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.dms.exception.DepartmentNotFoundException;
import com.coforge.dms.model.Department;
import com.coforge.dms.repo.DepartmentRepo;

import jakarta.validation.Valid;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepo repo;
	private Environment environment;

	@Autowired
	public DepartmentServiceImpl(DepartmentRepo repo, Environment environment) {
		super();
		this.repo = repo;
		this.environment = environment;
	}

	@Override
	public boolean saveDept(Department department) {
		repo.save(department);
		return true;
	}

	@Override
	public boolean updateDeptById(int dno, @Valid Department department) {
		if (!repo.existsById(dno))
			throw new DepartmentNotFoundException(environment.getProperty("dms.invalid.emp-notfound"));
		repo.save(department);
		return true;
	}

	@Override
	public boolean deleteDeptById(int dno) {
		if (!repo.existsById(dno))
			throw new DepartmentNotFoundException(environment.getProperty("dms.invalid.emp-notfound"));
		repo.deleteById(dno);
		return true;
	}

	@Override
	public Optional<Department> findDeptById(int dno) {
		if (!repo.existsById(dno))
			throw new DepartmentNotFoundException(environment.getProperty("dms.invalid.emp-notfound"));
		Optional<Department> departments = repo.findById(dno);
		return departments;
	}

	@Override
	public List<Department> findDepts() {
		List<Department> departments = (List<Department>) repo.findAll();
		return departments;
	}

}
