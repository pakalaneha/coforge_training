package com.coforge.day3;

import java.util.Scanner;

public class FactorialTableApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the limit");
		int n = sc.nextInt();
		
		int fact = 1;
		for(int i = 1; i <= n; i++) {
			fact = fact * i;
			System.out.println(i + " Factorial is : " + fact);
		}
		
		//System.out.println("Factorial : " + fact);
		
		sc.close();
	}

}
