package com.coforge.day3;

import java.util.Scanner;

public class MultiplicationTableApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a Number : ");
		int n = sc.nextInt();
		
		System.out.println("Multiplication Table of " + n + " is: ");
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(n + " x " + i + " = " + n*i);
		}
		
		sc.close();
	}

}
