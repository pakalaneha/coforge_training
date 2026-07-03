package com.coforge.day3;

public class EmployeeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee neha = new Employee(1, "Neha", 15000);
		neha.display();
		
		neha.setSalary(20000);
		neha.display();
		
		Employee harshika = new Employee(2, "harshika", 15000);
		harshika.display();
		
		System.out.println(harshika.getSalary());
	}

}
