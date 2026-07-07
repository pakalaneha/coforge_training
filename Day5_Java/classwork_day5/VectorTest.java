package com.coforge.day5;

import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;

public class VectorTest { // implements List interface
	
	public static void main(String[] args) {

		Vector<Integer> list1 = new Vector<>(); 
		
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
		
		//Traverse using Enumeration  //enumeration is a legacy interface 
		Enumeration<Integer> e = list1.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
}
