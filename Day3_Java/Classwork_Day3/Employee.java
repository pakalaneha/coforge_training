package com.coforge.day3;

//Java Bean or POJO Class (plain old java object) or model class
public class Employee {
	private int eid;
	private String ename;
	private double esalary;
	
	public Employee(int eid, String ename, double esalary) {
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
	}
	
	public void setSalary(double esalary) { //Setter Method
		this.esalary = esalary;
	}
	
	public double getSalary() { //Getter Method
		return esalary;
	}
	
	public void display() {
		System.out.println("Employee Id : " + eid);
		System.out.println("Employee Name : " + ename);
		System.out.println("Employee Salary : " + esalary);
	}
}
