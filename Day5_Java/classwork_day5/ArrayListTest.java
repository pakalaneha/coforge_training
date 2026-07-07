package com.coforge.day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest { // implements List interface
	
	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<>(); 
		
		// using dmd //<> -> generics; says the type of elements to be stored.
		// generic works in compilation time, not compile time. therefore, Arraylist<>()
		// instead of ArrayList<Integer>()
		
		list1.add(new Integer(10)); //boxing
		list1.add(20); //auto boxing
		list1.add(30);
		list1.add(40);
		list1.add(50);
		list1.add(20);
		System.out.println(list1);
		
		//accesing a value
		System.out.println(list1.get(1));
		
		//remove
		System.out.println(list1.remove(2));
		System.out.println(list1);
		
		//update
		list1.set(0,60);
		System.out.println(list1);
		
		//Traverse using for loop
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		System.out.println("----");
		
		//Traverse using enhanced for loop
		for(Integer i : list1) {
			System.out.println(i);
		}
		System.out.println("----");
		
		//Traverse using Iterator Interface
		Iterator<Integer> it = list1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("----");
	}
}
