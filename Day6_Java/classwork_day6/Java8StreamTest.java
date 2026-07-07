package com.coforge.day6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> even = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

		System.out.println(even); // [2, 4]

		long count = list.stream().filter(n -> n % 2 == 0).count();
		System.out.println(count);

		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
		
		list.stream().filter(n -> n % 2 == 0).map(n -> n * 2).forEach(System.out::println);
		
		List<String> names = Arrays.asList("Shimla", "Meghalaya", "Manali", "Shillong");
		
		names.stream().filter(n -> n.contains("a")).forEach(System.out::println);
		
		names.stream().filter(n -> n.contains("a")).map(s -> s.length()).forEach(System.out::println);
		names.stream().filter(n -> n.contains("a")).forEach(x -> System.out.println(x.length()));
		
		List<String> name = Arrays.asList("a", "ab", "Manali", "Shillong");
		Map<Integer, String> map = name.stream().collect(Collectors.toMap(x -> x.length(), x -> x));
		System.out.println(map);
		
		Date date = new Date();
		System.out.println(date);
		
		LocalDate dat = LocalDate.now();
		System.out.println(dat);
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
	}

}
