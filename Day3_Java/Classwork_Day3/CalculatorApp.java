package com.coforge.day3;

import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter two numbers");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int result=0;
		String confirmation = "";
		do {		
		System.out.println("1.Add 2.Sub 3.Mul 4.Div 5.Quit");
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1 : 
			result = a + b;
			System.out.println("Addition : " + result);
			break;
		case 2 : 
			result = a - b;
			System.out.println("Subtraction : " + result);
			break;
		case 3 : 
			result = a * b;
			System.out.println("Multiplication : " + result);
			break;
		case 4 : 
			result = a / b;
			System.out.println("Division : " + result);
			break;
		case 5 : 
			System.exit(0);

		}
		
		System.out.println("Do you want to continue [Yes | No]");
		confirmation = sc.next();
		} while(confirmation.equalsIgnoreCase("Yes"));
		
		sc.close();
	}

}
