package com.coforge.day5;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
		map.put(10, "Java");
		map.put(5, "Python");
		map.put(20, "Angular");
		map.put(30, "React");

		System.out.println(map);

		map.put(30, "Streamlit"); // update
		System.out.println(map);

		map.remove(5); // remove
		System.out.println(map);

		System.out.println(map.get(10));
		
		System.out.println("----");

		// Traverse the map using enhanced for loop
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			System.out.println(key + " => " + map.get(key));
		}

		System.out.println("----");

		// Traverse the map using entrySet
		Set<Entry<Integer, String>> entries = map.entrySet();
		for (Entry entry : entries) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}

	}

}
