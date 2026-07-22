package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import com.coforge.ems.model.Employee;

public interface EmployeeService {

	public boolean saveEmployee(Employee employee);

	public boolean updateEmployee(int eid, Employee employee);

	public boolean deleteEmployee(int eid);

	public Optional<Employee> findEmployee(int eid);

	public List<Employee> findAllEmployees();

	public List<Employee> findByEname(String ename);

	public boolean deleteByEname(String ename);

	public List<Integer> getEidsList();

	public String getInfo();

}
