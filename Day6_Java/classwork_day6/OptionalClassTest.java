package com.coforge.day6;

import java.util.Optional;

class Employee {
	private int eid;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

}

public class OptionalClassTest {

	public static Optional<Employee> getEmployee() {
		Employee employee = null;
		Optional<Employee> optionalEmployee = Optional.ofNullable(employee);
		return optionalEmployee;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalEmployee = getEmployee();

		if (optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			System.out.println(employee.getEid());
		} else {
			System.out.println("Employee Not Found");
		}
	}

}
