package com.coforge.day3;

import java.util.Scanner;

public class GradeCalculatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Marks : ");
		int marks = sc.nextInt();
		if (marks < 0 || marks > 100) {
			System.out.println("Invalid Marks");
		} else if (marks >= 90) {
			System.out.println(marks + " Grade A");
		} else if (marks >= 80) {
			System.out.println(marks + " Grade B");
		} else if (marks >= 70) {
			System.out.println(marks + " Grade C");
		} else if (marks >= 60) {
			System.out.println(marks + " Grade D");
		} else {
			System.out.println(marks + " Grade F");
		}

		sc.close();
	}

}
