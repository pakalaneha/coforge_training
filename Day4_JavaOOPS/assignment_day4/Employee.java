package com.coforge.assignment;

public class Employee {
	String empName;
	int empId;
	int monthlySalary;
	
	Employee(String empName, int empId, int monthlySalary){
		this.empName = empName;
		this.empId = empId;
		this.monthlySalary = monthlySalary;
	}
	
	public int annualSalary() {
		return monthlySalary * 12;
	}
	
	public void displayEmployee() {
		System.out.println("Employee ID : "+empId);
		System.out.println("Employee Name : "+ empName);
		System.out.println("Employee MonthlySalary : "+monthlySalary);
		System.out.println("Annual Salary : "+annualSalary());
	}
	public static void main(String[] args) {
		Employee employee = new Employee("Priya", 1023, 40000);
		
		employee.displayEmployee();
		
		
	}
	
	
}
