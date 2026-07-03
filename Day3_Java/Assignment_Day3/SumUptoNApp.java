package com.coforge.day3;

import java.util.Scanner;

public class SumUptoNApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a Number : ");
		int n = sc.nextInt();
		
		long sum = n * (n + 1)/2L;
		
		System.out.println("Sum of Natural Numbers from 1 to " + n + " is : "+ sum);
		
		sc.close();
	}

}
