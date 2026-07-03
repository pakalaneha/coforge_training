package com.coforge.day3;

import java.util.Scanner;

public class PrimeNumberCheckApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a Number : ");
		int n = sc.nextInt();

		boolean flag = false;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				flag = true;
				break;
			}
		}
		if (n <= 1) {
			System.out.println(n + " is neither a prime nor composite");
		} else if (flag) {
			System.out.println(n + " is not a Prime Number");
		} else {
			System.out.println(n + " is a Prime Number");
		}

		sc.close();
	}

}
