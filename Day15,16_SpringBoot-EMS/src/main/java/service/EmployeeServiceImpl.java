package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo repo;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public boolean saveEmployee(Employee employee) throws InvalidEmployeeObjectException {

		// validation
		if (employee != null && employee.getEid() > 0 && employee.getEname() != null && employee.getEsalary() > 0
				&& employee.getDno() > 0) {
			repo.save(employee); // save is like create/insert and update too it will return object or exception
			return true;
		} else {
			throw new InvalidEmployeeObjectException();
		}

	}

	@Override
	public boolean updateEmployee(int eid, Employee employee)
			throws InvalidEmployeeObjectException, EmployeeNotFoundException {
		// validation
		if (eid > 0 && employee != null && employee.getEid() > 0 && employee.getEname() != null
				&& employee.getEsalary() > 0 && employee.getDno() > 0) {
			// in real time before save we validate by dng the following process:
			// get all ids from db save them in list check if eid is present and then update
			if (!repo.existsById(eid)) {
				throw new EmployeeNotFoundException();
			}
			repo.save(employee); // save is like create/insert and update too it will return object or exception
			return true;
		} else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	public boolean deleteEmployee(int eid) throws InvalidEmployeeObjectException, EmployeeNotFoundException {
		if (eid > 0) {
			// in real time before save we validate by dng the following process:
			// get all ids from db save them in list check if eid is present and then update
			if (!repo.existsById(eid)) {
				throw new EmployeeNotFoundException();
			}
			repo.deleteById(eid); // save is like create/insert and update too it will return object or exception
			return true;
		} else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	public Optional<Employee> findEmployee(int eid) throws InvalidEmployeeObjectException, EmployeeNotFoundException {
		// TODO Auto-generated method stub
		if (eid > 0) {
			// in real time before save we validate by dng the following process:
			// get all ids from db save them in list check if eid is present and then update
			if (!repo.existsById(eid)) {
				throw new EmployeeNotFoundException();
			}
			return repo.findById(eid);
		} else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	public List<Employee> findAllEmployees() {
		return (List<Employee>) repo.findAll();
		

	}

	@Override
	public List<Employee> findByEname(String ename) throws InvalidEmployeeObjectException, EmployeeNotFoundException {
		if (ename != null) {
			List<Employee> employees = repo.findByEname(ename);
			if(employees.isEmpty()) {
				throw new EmployeeNotFoundException();
			}
			return employees;
		} else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	@Transactional //for insert, delete, update database shd commit that's why transactional annotation is used to 
	//make changes in database
	public boolean deleteByEname(String ename) throws InvalidEmployeeObjectException,EmployeeNotFoundException{
		if(ename != null) {
			int n = repo.deleteByEname(ename);
			if(n == 0) {
				throw new EmployeeNotFoundException();
			}
			return true;
		}
		else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	public List<Integer> getEidsList() {
		List<Integer> eids = repo.getEids();
		return eids;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String info = repo.getInfo();
		return info;
	}

}
