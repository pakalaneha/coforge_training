package com.coforge.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coforge.ems.model.Employee;

@Service
public class EmployeeService {
	private List<Employee> list = new ArrayList<>();

	public boolean createEmployee(Employee employee) {
		// TODO Auto-generated method stub

		boolean status = list.add(employee);
		return status;
	}

	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

		for (int i = 0; i < list.size(); i++) {
			Employee emp = list.get(i);
			if (emp.getEid() == employee.getEid()) {
				list.remove(i);
				list.add(employee);
				return true;
			}
		}

		return false;
	}

	public boolean deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		//boolean status = false;

		for (int i = 0; i < list.size(); i++) {
			Employee emp = list.get(i);
			if (emp.getEid() == eid) {
				list.remove(i);
				return true;
			}
		}

		return false;
	}

	public Employee findEmployee(int eid) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			Employee emp = list.get(i);
			if (emp.getEid() == eid) {
				return emp;
			}
		}
		return null;
	}

	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return list;
	}
}
