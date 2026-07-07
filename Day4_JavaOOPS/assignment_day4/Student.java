package com.coforge.assignment;

public class Student {
	int id;
	String name;
	int marks;
	
	Student(int id, String name, int marks){
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	public void display() {
		System.out.println("Student ID : "+ id);
		System.out.println("Student Name : "+ name);
		System.out.println("Student Marks : "+ marks);
	}
	
	public void grade() {
		if(marks <=100 && marks>90) System.out.println("Grade A");
		else if(marks < 90 && marks > 60) System.out.println("Grade B");
		else if(marks <60 && marks >30) System.out.println("Grade C");
		else System.out.println("Grade D");
	}
	
	public static void main(String[] args) {
		
		Student student = new Student(101, "Satvika", 87 );
		
		student.display();
		student.grade();
	}
}
