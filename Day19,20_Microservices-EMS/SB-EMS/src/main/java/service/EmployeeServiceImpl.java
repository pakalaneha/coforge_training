package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.ems.dto.DepartmentDTO;
import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;
import com.coforge.ems.service.client.DepartmentClient;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo repo;
	private Environment environment;
	private DepartmentClient client;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo repo, Environment environment, DepartmentClient client) {
		super();
		this.repo = repo;
		this.environment = environment;
		this.client = client;
	}

	@Override
	public boolean saveEmployee(Employee employee) {

		// validation
//		if (employee != null && employee.getEid() > 0 && employee.getEname() != null && employee.getEsalary() > 0
//				&& employee.getDno() > 0) {
			repo.save(employee); // save is like create/insert and update too it will return object or exception
			return true;
//		} else {
//			throw new InvalidEmployeeObjectException(environment.getProperty("ems.invalid.emp-details"));
//		}

	}

	@Override
	public boolean updateEmployee(int eid, Employee employee){
		// validation
//		if (eid > 0 && employee != null && employee.getEid() > 0 && employee.getEname() != null
//				&& employee.getEsalary() > 0 && employee.getDno() > 0) {
			// in real time before save we validate by dng the following process:
			// get all ids from db save them in list check if eid is present and then update
			if (!repo.existsById(eid)) {
				throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.not-found"));
			}
			repo.save(employee); // save is like create/insert and update too it will return object or exception
			return true;
//		} else {
//			throw new InvalidEmployeeObjectException();
//		}
	}

	@Override
	public boolean deleteEmployee(int eid) {
		//if (eid > 0) {
			// in real time before save we validate by dng the following process:
			// get all ids from db save them in list check if eid is present and then update
			if (!repo.existsById(eid)) {
				throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.not-found"));
			}
			repo.deleteById(eid); // save is like create/insert and update too it will return object or exception
			return true;
//		} else {
//			throw new InvalidEmployeeObjectException();
//		}
	}

	@Override
	public Optional<Employee> findEmployee(int eid) {
		// TODO Auto-generated method stub
		//if (eid > 0) {
			// in real time before save we validate by dng the following process:
			// get all ids from db save them in list check if eid is present and then update
			if (!repo.existsById(eid)) {
				throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.not-found"));
			}
			return repo.findById(eid);
//		} else {
//			throw new InvalidEmployeeObjectException();
//		}
	}

	@Override
	public List<Employee> findAllEmployees() {
		return (List<Employee>) repo.findAll();
		

	}

	@Override
	public List<Employee> findByEname(String ename) {
		//if (ename != null) {
			List<Employee> employees = repo.findByEname(ename);
			if(employees.isEmpty()) {
				throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.not-found"));
				}
			return employees;
//		} else {
//			throw new InvalidEmployeeObjectException();
//		}
	}

	@Override
	@Transactional //for insert, delete, update database shd commit that's why transactional annotation is used to 
	//make changes in database
	public boolean deleteByEname(String ename){
		//if(ename != null) {
			int n = repo.deleteByEname(ename);
			if(n == 0) {
				throw new EmployeeNotFoundException(environment.getProperty("ems.invalid.not-found"));
			}
			return true;
//		}
//		else {
//			throw new InvalidEmployeeObjectException(environment.get);
//		}
	}

	@Override
	public List<Integer> getEidsList() {
		List<Integer> eids = repo.getEids();
		return eids;
	}

	@Override
	public String getInfo() {
		String info = repo.getInfo();
		return info;
	}

	//Rest service methods for feign client department
	@Override
	public DepartmentDTO findDepartmentById(int dno) {
		DepartmentDTO department = client.findDepartmentById(dno);
		return department;
	}

	@Override
	public List<DepartmentDTO> findAllDepartments() {
		List<DepartmentDTO> departments = client.findAllDepartments();
		return departments;
	}

}
