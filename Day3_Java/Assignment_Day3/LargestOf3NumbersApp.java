package com.coforge.day3;

import java.util.Scanner;

public class LargestOf3NumbersApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 3 Numbers : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		if (a >= b && a >= c) {
			System.out.println(a + " is a largest number.");
		} else if (b >= a && b >= c) {
			System.out.println(b + " is a largest number.");
		} else {
			System.out.println(c + " is a largest number.");
		}

		sc.close();
	}

}
