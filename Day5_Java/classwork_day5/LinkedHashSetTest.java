package com.coforge.day5;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest { 
	
	public static void main(String[] args) {

		Set<Integer> set1 = new LinkedHashSet<>(); 
		
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
