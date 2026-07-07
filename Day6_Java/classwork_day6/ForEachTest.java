package com.coforge.day6;

import java.util.Arrays;
import java.util.List;

public class ForEachTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		// traditional and enhanced

		// for each
		// lambda
		list.forEach(n -> System.out.println(n));
		System.out.println("----------------------");

		list.forEach(n -> {
			if (n % 2 == 0)
				System.out.println(n);
		});
		System.out.println("----------------------");

		// method reference
		list.forEach(System.out::println);

	}

}
