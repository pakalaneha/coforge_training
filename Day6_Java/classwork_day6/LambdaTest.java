package com.coforge.day6;

@FunctionalInterface
interface Calculator {
	public int calc(int a, int b);
}

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calculator = (a, b) -> a + b;
		System.out.println(calculator.calc(10, 20));

//		Calculator subtraction = (a, b) -> a - b;
//		System.out.println(subtraction.calc(10, 20));

		calculator = (a, b) -> a - b;
		System.out.println(calculator.calc(10, 20));

	}

}
