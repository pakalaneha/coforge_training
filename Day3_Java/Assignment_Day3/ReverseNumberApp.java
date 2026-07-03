package com.coforge.day3;

import java.util.Scanner;

public class ReverseNumberApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a Number : ");
		int n = sc.nextInt();

		int t = n;
		int reverseNumber = 0;
		while (t > 0) {
			reverseNumber = reverseNumber * 10 + t % 10;
			t /= 10;
		}

		System.out.println("Reverse Number is : " + reverseNumber);

		sc.close();
	}

}
