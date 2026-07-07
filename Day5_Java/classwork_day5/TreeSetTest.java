package com.coforge.day5;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest { 
	
	public static void main(String[] args) {

		Set<Integer> set1 = new TreeSet<>(); //default ascending order
		//Set<Integer> set1 = new TreeSet<>(Collections.reverseOrder());  // for descending order
		
		set1.add(new Integer(10)); //boxing
		set1.add(20); //auto boxing
		set1.add(30);
		set1.add(40);
		set1.add(50);
		set1.add(20);
		System.out.println(set1);
						
		//remove
		System.out.println(set1.remove(20));
		System.out.println(set1);
		
		System.out.println(set1);
		
		
		System.out.println("----");
		
		//Traverse using enhanced for loop
		for(Integer i : set1) {
			System.out.println(i);
		}
		System.out.println("----");
		
		//Traverse using Iterator Interface
		Iterator<Integer> it = set1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("----");
	}
}
